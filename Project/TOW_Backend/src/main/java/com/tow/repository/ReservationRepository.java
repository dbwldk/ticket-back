package com.tow.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tow.domain.ReservationDB;

public interface ReservationRepository extends JpaRepository<ReservationDB, Integer> {
	//티켓의 총 알림 수 구하기
	@Query("SELECT COUNT(r) FROM ReservationDB r WHERE r.ticketId = :tId")
	long countByTid(@Param("tId") Integer tId);
	
	// 특정 ticketId와 email 조건에 맞는 엔티티 삭제
	void deleteByTicketIdAndEmail(Integer ticketId, String email);
	
	// 사용자의 알림 상태 확인하기
	@Query("SELECT COUNT(r) FROM ReservationDB r WHERE r.ticketId = :tId AND r.email = :uId")
	long countByTidAndUid(@Param("tId") Integer tId, @Param("uId") String uId);
}
