package com.tow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tow.domain.NaverUserDB;

public interface UserRepository extends JpaRepository<NaverUserDB, String> {
    // 사용자 ID로 조회하는 메서드 (String 타입)
    Optional<NaverUserDB> findById(String id);
}
