package com.tow.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tow.domain.TicketDB;
import com.tow.service.DetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class DetailController {
	@Autowired
	private DetailService detailService;
	
	@GetMapping("info")
	public Optional<TicketDB> getInfo(@RequestParam int id) {
		return detailService.getInfo(id);
	}
	
}
