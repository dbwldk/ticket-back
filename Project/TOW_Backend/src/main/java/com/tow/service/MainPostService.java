package com.tow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tow.domain.MainPostTicketDB;
import com.tow.repository.MainPostTicketRepository;

@Service
public class MainPostService {
	@Autowired
    private MainPostTicketRepository ticketReq;
    
    public List<MainPostTicketDB> getAll() {
        return ticketReq.findAll();
    }
    
    public List<MainPostTicketDB> getByGenre(String genre) {
        return ticketReq.findByGenre(genre);
    }
}
