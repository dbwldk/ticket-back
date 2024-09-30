package com.tow.repository;

import com.tow.domain.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserVO, String> {
}
