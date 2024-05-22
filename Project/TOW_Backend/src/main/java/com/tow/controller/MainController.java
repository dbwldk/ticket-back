package com.tow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tow.domain.TicketDB;
import com.tow.service.MainService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class MainController {
	@Autowired
	private MainService mainService;
	
	@GetMapping("all")
	public List<TicketDB> main() {
		return mainService.getAll();
	}
	
}
