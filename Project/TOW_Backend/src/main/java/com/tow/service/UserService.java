package com.tow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tow.domain.NaverUserDB;
import com.tow.repository.NaverUserRepository;
import com.tow.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private NaverUserRepository userRepository;

    public NaverUserDB registerUser(NaverUserDB user) {
        return userRepository.save(user);
    }
    
    public boolean authenticateUser(String email, String password) {
        Optional<NaverUserDB> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            NaverUserDB user = userOptional.get();
            return user.getPassword().equals(password); // 비밀번호 비교
        }
        return false; // 사용자 없음
    }
    
    // 네이버 로그인이면 "naver", 자체 로그인이면 "normal" 반환
    public String checkLoginType(String email) {
    	boolean IsNaverLogin = userRepository.IsNaverLoginFindByEmail(email); //naver면 true 반환
    	if(IsNaverLogin) {
    		return "naver";
    	} else {
    		return "normal";
    	}
    }
    
    // 로그인 한 사용자 이름 받아오기
    public String getNameWhoLogin(String email) {
    	return userRepository.findNameByEmail(email);
    }
    
    // 비밀번호 변경
    public boolean updatePassword(String email, String newPassword) {
        Optional<NaverUserDB> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            NaverUserDB user = userOptional.get();
            user.setPassword(newPassword); // 비밀번호 업데이트
            userRepository.save(user); // 변경 사항 저장
            return true;
        }
        return false; // 사용자 없음
    }
    
//    // 사용자 인증 및 비밀번호 변경 로직
//    public boolean updatePassword(String email, String currentPassword, String newPassword) {
//        // 사용자 인증 로직
//        NaverUserDB user = userRepository.findByEmail(email);
//        if (user != null && passwordEncoder.matches(currentPassword, user.getPassword())) {
//            // 비밀번호 변경
//            user.setPassword(passwordEncoder.encode(newPassword));
//            userRepository.save(user);
//            return true;
//        }
//        return false;
//    }
}
