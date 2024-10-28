package com.tow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tow.domain.LikeDB;
import com.tow.domain.TicketDB;
import com.tow.domain.vo.TicketLikeVO;
import com.tow.repository.LikeRepository;
import com.tow.repository.TicketRepository;
import com.tow.repository.TicketViewsRepository;

@Service
public class DetailService {
	@Autowired
	private TicketRepository ticketReq;
	@Autowired
	private TicketViewsRepository ticketViewRep;
	@Autowired
	private LikeRepository likeRep;
	
	//티켓 상세 정보 조회
	public Optional<TicketDB> getInfo(int id) {
		return ticketReq.findTicketAndSites(id);
	}
	
	//조회수 증가
	@Transactional
	public void incrementViewCnt(Integer ticketId) {
		ticketViewRep.incrementViewsByTicketId(ticketId);
	}
	
	// 좋아요 클릭
	public void saveTicketLike(Integer ticketId, String uId) {
		LikeDB ticketLike = new LikeDB();
		ticketLike.setTicketId(ticketId);
		ticketLike.setUserId(uId);
		likeRep.save(ticketLike);
	}
	
	// 좋아요 해제
	@Transactional
	public void deleteTicketLike(Integer ticketId, String uId) {
		likeRep.deleteByTicketIdAndUserId(ticketId, uId);
	}
	
	// 좋아요 상태 확인
	public boolean likeStateCk(Integer ticketId, String uId) {
		long state = likeRep.countByTidAndUid(ticketId, uId);
		if(state > 0) { //존재
			return true;
		} else {
			return false;
		}
	}
	
	// 좋아요 수 가져오기
	public long getCntLike(Integer ticketId) {
		return likeRep.countByTid(ticketId);
	}
	
	// 좋아요 수 비율 구하기
	public TicketLikeVO getPerForAge(Integer ticketId) {
		// 총 좋아요 수
		long totalLikeCnt = likeRep.countByTid(ticketId);
		System.out.println(totalLikeCnt);
		if(totalLikeCnt == 0) { // 좋아요가 없다면
			return null;
		}
		
		// 연령별 좋아요 수: 10~60대, 형식: '10-19'
		String[] ageArr = {"10-19", "20-29", "30-39", "40-49", "50-59", "60-69"};
		double[] agePerArr = new double[6];
		
		for(int i = 0 ; i < ageArr.length; i++){
			long totalCnt = likeRep.countByTidAndAge(ticketId, ageArr[i]);
			agePerArr[i] = ((double) totalCnt / totalLikeCnt) * 100;
			System.out.println(i + " : " + totalCnt);
			System.out.println(agePerArr[i]);
        }
		
		TicketLikeVO tkLike = new TicketLikeVO();
		tkLike.setTkId(ticketId);
		tkLike.setPerFor10(agePerArr[0]);
		tkLike.setPerFor20(agePerArr[1]);
		tkLike.setPerFor30(agePerArr[2]);
		tkLike.setPerFor40(agePerArr[3]);
		tkLike.setPerFor50(agePerArr[4]);
		tkLike.setPerFor60(agePerArr[5]);
		
		return tkLike;
	}
}
