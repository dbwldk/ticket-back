package com.tow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tow.domain.LikeDB;
import com.tow.domain.ReservationDB;
import com.tow.repository.LikeRepository;
import com.tow.repository.ReservationRepository;

@Service
public class MyPageService {
	@Autowired
	private LikeRepository likeRep;
	@Autowired
    private ReservationRepository reservationRepository;
	
	/* 좋아요 */
	//유저가 좋아요 누른 티켓 리스트 가져오기
	public List<LikeDB> getLikeList(String userId) {
		return likeRep.findByUserIdOrderByLikeTimeDesc(userId);
	}
	
	// 유저가 좋아요 누른 티켓 수
	public long getLikeCnt(String userId) {
		return likeRep.countByUserId(userId);
	}
	
	/* 알림 */
	//유저가 알림 누른 티켓 리스트 가져오기
	public List<ReservationDB> getBellList(String userId) {
		return reservationRepository.findByEmailOrderByReservationTimeDesc(userId);
	}
	
	// 유저가 알림 누른 티켓 수
	public long getBellCnt(String userId) {
		return reservationRepository.countByUserId(userId);
	}
	
	
}
