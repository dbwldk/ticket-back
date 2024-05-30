package com.tow.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tow.domain.vo.LocalVO;
import com.tow.domain.vo.NaverResultVO;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class NaverSearchController {
	
	@Value("${NAVER_SEARCH_CLIENT_ID}")
	private String NaverClientId;
	
	@Value("${NAVER_SEARCH_CLIENT_SECRET}")
	private String NaverClientSecret;
	
	@GetMapping("naverSearch")
	public List<LocalVO> getMethodName(@RequestParam String searchPlace) {
		//uri 설정
		URI uri = UriComponentsBuilder
				.fromUriString("https://openapi.naver.com")
				.path("/v1/search/local.json")
				.queryParam("query", searchPlace)
				.queryParam("display", 10)
				.queryParam("start", 1)
                .queryParam("sort", "random")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();
		
		//request & response
		RestTemplate restTemplate = new RestTemplate();		
		RequestEntity<Void> req = RequestEntity
				.get(uri)
				.header("X-Naver-Client-Id", NaverClientId)
				.header("X-Naver-Client-Secret", NaverClientSecret)
				.build();
		ResponseEntity<String> response = restTemplate.exchange(req, String.class);
		
		//vo에 넣어서 json으로 내보내기
		ObjectMapper om = new ObjectMapper();
		NaverResultVO resultVO = null;
		
		try {
			resultVO = om.readValue(response.getBody(), NaverResultVO.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
        return resultVO != null ? resultVO.getItems() : null;
	}
	
	
}
