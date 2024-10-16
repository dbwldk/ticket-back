package com.tow.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "naver_user")
public class NaverUserDB {
    
    @Id
    private String id; // 기본 키
    private String name; // 이름
    private String email; // 이메일
    private String gender; // 성별
    private String age;
}