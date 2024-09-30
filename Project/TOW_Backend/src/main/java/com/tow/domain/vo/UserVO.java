package com.tow.domain.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class UserVO {

    @Id
    private String id;
    private String email;
    private String Name;
    private String gender;
    private String birthday;
    private String phone;

}
