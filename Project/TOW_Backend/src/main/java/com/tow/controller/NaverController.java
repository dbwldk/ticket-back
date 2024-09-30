package com.tow.controller;

import com.tow.domain.vo.UserVO;
import com.tow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@RestController
@RequestMapping("/api/naver")
public class NaverController {

    @Value("${naver.client.id}")
    private String clientId;

    @Value("${naver.client.secret}")
    private String clientSecret;

    @Value("${naver.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserRepository userRepository;

    // 네이버 로그인 URL 생성
    @GetMapping("/login")
    public ResponseEntity<String> naverLoginUrl() {
        String encodedRedirectUri = URLEncoder.encode(redirectUri, StandardCharsets.UTF_8);
        String naverLoginUrl = "https://nid.naver.com/oauth2.0/authorize" +
                "?response_type=code" +
                "&client_id=" + clientId +
                "&redirect_uri=" + encodedRedirectUri +
                "&state=STATE_STRING";
        return ResponseEntity.ok(naverLoginUrl);
    }

    // 네이버 로그인 콜백 처리
    @GetMapping("/callback")
    public ResponseEntity<String> naverCallback(@RequestParam String code, @RequestParam String state) {
        try {
            // 1. 액세스 토큰 요청
            String tokenUrl = "https://nid.naver.com/oauth2.0/token" +
                    "?grant_type=authorization_code" +
                    "&client_id=" + clientId +
                    "&client_secret=" + clientSecret +
                    "&code=" + code +
                    "&state=" + state;

            RestTemplate restTemplate = new RestTemplate();
            String tokenResponse = restTemplate.getForObject(new URI(tokenUrl), String.class);

            JSONParser parser = new JSONParser();
            JSONObject tokenJson = (JSONObject) parser.parse(tokenResponse);
            String accessToken = (String) tokenJson.get("access_token");

            // 2. 사용자 정보 요청
            String apiUrl = "https://openapi.naver.com/v1/nid/me";
            org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.set("Authorization", "Bearer " + accessToken);

            String userInfoResponse = restTemplate.getForObject(apiUrl, String.class, headers);
            JSONObject userInfoJson = (JSONObject) parser.parse(userInfoResponse);
            JSONObject response = (JSONObject) userInfoJson.get("response");

            // 3. 사용자 정보 파싱 및 저장
            UserVO user = new UserVO();
            user.setId((String) response.get("id"));
            user.setEmail((String) response.get("email"));

            // 4. 사용자 정보 저장 또는 업데이트
            Optional<UserVO> existingUser = userRepository.findById(user.getId());
            if (existingUser.isPresent()) {
                // 이미 존재하는 사용자면 정보 업데이트
                UserVO updatedUser = existingUser.get();
                updatedUser.setEmail(user.getEmail());
                updatedUser.setName(user.getName());
                userRepository.save(updatedUser);
            } else {
                // 새로운 사용자면 저장
                userRepository.save(user);
            }

            return ResponseEntity.ok("Login successful");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login failed");
        }
    }
}