package com.tow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tow.domain.TicketDB;
import com.tow.repository.TicketRepository;

@Service
public class DetailService {
	@Autowired
	private TicketRepository ticketReq;
	
	public Optional<TicketDB> getInfo(int id) {
		return ticketReq.findTicketAndSites(id);
	}
}
