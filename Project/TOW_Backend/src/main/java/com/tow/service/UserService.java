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
