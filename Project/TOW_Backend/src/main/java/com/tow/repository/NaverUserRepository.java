package com.tow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tow.domain.NaverUserDB;

public interface NaverUserRepository extends JpaRepository<NaverUserDB, String> {
	Optional<NaverUserDB> findByEmail(String email);

}
