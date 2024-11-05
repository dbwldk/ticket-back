package com.tow.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name = "ticket_reservation")
public class ReservationDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    
    @Column(name = "ticket_id") //티켓 아이디
    private Integer ticketId;

    @Column(name = "ticket_open_date")
    private LocalDateTime ticketOpenDate;  // 티켓 날짜

    @Column(name = "notification_hours")
    private int notificationHours;  // 사용자 설정 알림 시간

    @Column(name = "email_sent") // 데이터베이스에서의 열 이름
    private boolean emailSent; // 이메일 발송 상태
}
