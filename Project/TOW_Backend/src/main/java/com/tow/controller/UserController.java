package com.tow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tow.domain.NaverUserDB;
import com.tow.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public NaverUserDB register(@RequestBody NaverUserDB user) {
        return userService.registerUser(user);
    }
    
    @PostMapping("/login")
    public ResponseEntity<NaverUserDB> login(@RequestBody NaverUserDB user, HttpSession session) {
        boolean isAuthenticated = userService.authenticateUser(user.getEmail(), user.getPassword());
        if (isAuthenticated) {
            // 세션에 사용자 정보를 저장
            session.setAttribute("user", user);
            return ResponseEntity.ok(user); // NaverUserDB 객체를 반환
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // 인증 실패
        }
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return ResponseEntity.ok("로그아웃 성공");
    }
}

//package com.tow.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.tow.domain.NaverUserDB;
//import com.tow.domain.vo.UpdatePasswordRequestVO;
//import com.tow.service.UserService;
//
//import jakarta.servlet.http.HttpSession;
//
//@RestController
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/register")
//    public NaverUserDB register(@RequestBody NaverUserDB user) {
//       
//        return userService.registerUser(user);
//    }
//    
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody NaverUserDB user, HttpSession session) {
//        boolean isAuthenticated = userService.authenticateUser(user.getEmail(), user.getPassword());
//        if (isAuthenticated) {
//           // 세션에 사용자 정보를 저장
//           session.setAttribute("user", user);
//            return ResponseEntity.ok("");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
//        }
//    }
//    
//    @PostMapping("/logout")
//    public ResponseEntity<String> logout(HttpSession session) {
//        session.invalidate(); // 세션 무효화
//        return ResponseEntity.ok("로그아웃 성공");
//    }
    
//    @PutMapping("/update-password")
//    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordRequestVO request, HttpSession session) {
//        String userEmail = (String) session.getAttribute("userEmail"); // 세션에서 사용자 이메일 가져오기
//
//        if (userEmail == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 필요");
//        }
//
//        boolean isUpdated = userService.updatePassword(userEmail, request.getCurrentPassword(), request.getNewPassword());
//        if (isUpdated) {
//            return ResponseEntity.ok("비밀번호가 성공적으로 변경되었습니다.");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("현재 비밀번호가 올바르지 않습니다.");
//        }
//    }
    
//}