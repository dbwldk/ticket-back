package com.tow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tow.domain.MainPostTicketDB;
import com.tow.service.MainPostServcie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class MainPostController {
    @Autowired
    private MainPostServcie mainpostService;
    
    //Top10
    @GetMapping("/top10")
    public List<MainPostTicketDB> getTop10() {
        return mainpostService.getTop10();
    }
    
    //월별
    @GetMapping("/month")
	public List<MainPostTicketDB> getMonth() {
		return mainpostService. getTicketsForCurrentMonth(6);
	}
    
    @GetMapping("/alllist")
  	public List<MainPostTicketDB> getalllist() {
  		return mainpostService.getAll();
  	}
}