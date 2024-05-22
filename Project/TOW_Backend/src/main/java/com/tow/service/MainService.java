package com.tow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tow.domain.TicketDB;
import com.tow.repository.TicketRepository;

@Service
public class MainService {
	@Autowired
	private TicketRepository ticketReq;
	
	public List<TicketDB> getAll() {
		return ticketReq.findAll();
	}
}
