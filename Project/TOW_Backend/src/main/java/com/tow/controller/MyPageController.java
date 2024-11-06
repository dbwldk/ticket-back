package com.tow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tow.domain.LikeDB;
import com.tow.domain.ReservationDB;
import com.tow.service.MyPageService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("mypage")
public class MyPageController {
	@Autowired
	private MyPageService myPageService;
	
	/* 좋아요 */
	// 좋아요 리스트 가져오기
	@GetMapping("likeList")
	public List<LikeDB> getLikeList(@RequestParam String userId) {
		return myPageService.getLikeList(userId);
	}
	
	// 좋아요 수 가져오기
	@GetMapping("likeCnt")
	public long getLikeCnt(@RequestParam String userId) {
		return myPageService.getLikeCnt(userId);
	}
	
	/* 알림 */
	// 알림 리스트 가져오기
	@GetMapping("bellList")
	public List<ReservationDB> getbellList(@RequestParam String userId) {
		return myPageService.getBellList(userId);
	}
	
	// 알림 수 가져오기
	@GetMapping("bellCnt")
	public long getbellCnt(@RequestParam String userId) {
		return myPageService.getBellCnt(userId);
	}
	
	
	
	
	
	
}
