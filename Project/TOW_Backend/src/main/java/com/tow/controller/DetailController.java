package com.tow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tow.domain.LikeDB;
import com.tow.domain.TicketDB;
import com.tow.domain.vo.TicketLikeVO;
import com.tow.service.DetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class DetailController {
	@Autowired
	private DetailService detailService;
	
	@GetMapping("info")
	public Optional<TicketDB> getInfo(@RequestParam Integer id) {
		detailService.incrementViewCnt(id);
		return detailService.getInfo(id);
	}
	
	// 좋아요 버튼 클릭
	@GetMapping("clickLike")
	public void clickLike(@RequestParam Integer tId, @RequestParam String uId) {
		detailService.saveTicketLike(tId, uId);
	}
	
	// 좋아요 버튼 해제
	@GetMapping("cancelLike")
	public void cancelLike(@RequestParam Integer tId, @RequestParam String uId) {
		detailService.deleteTicketLike(tId, uId);
	}
	
	// 좋아요 상태
	@GetMapping("likeCheck")
	public boolean likeCheck(@RequestParam Integer tId, @RequestParam String uId) {
		return detailService.likeStateCk(tId, uId);
	}
	
	// 좋아요 수 가져오기
	@GetMapping("ticketLike")
	public long getTicketLike(@RequestParam Integer tId) {
		return detailService.getCntLike(tId);
	}
	
	// 좋아요 수 비율 가져오기
	@GetMapping("ticketLikePer")
	public TicketLikeVO getTicketLikePer(@RequestParam Integer tId) {
		return detailService.getPerForAge(tId);
	}
	
	
}
