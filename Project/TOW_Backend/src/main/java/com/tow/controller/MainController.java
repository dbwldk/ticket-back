package com.tow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tow.domain.TicketDB;
import com.tow.service.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class MainController {
	@Autowired
	private MainService mainService;
	
	@GetMapping("all")
	public List<TicketDB> main() {
		return mainService.getAll();
	}
	
	@GetMapping("one")
	public Optional<TicketDB> getMethodName(@RequestParam int id) {
		return mainService.getOne(id);
	}
	
	
}
