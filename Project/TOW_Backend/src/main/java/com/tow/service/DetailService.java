package com.tow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tow.domain.TicketDB;
import com.tow.repository.TicketRepository;
import com.tow.repository.TicketViewsRepository;

@Service
public class DetailService {
	@Autowired
	private TicketRepository ticketReq;
	@Autowired
	private TicketViewsRepository ticketViewRep;
	
	//티켓 상세 정보 조회
	public Optional<TicketDB> getInfo(int id) {
		return ticketReq.findTicketAndSites(id);
	}
	
	//조회수 증가
	@Transactional
	public void incrementViewCnt(Integer ticketId) {
		ticketViewRep.incrementViewsByTicketId(ticketId);
	}
	
	
}
