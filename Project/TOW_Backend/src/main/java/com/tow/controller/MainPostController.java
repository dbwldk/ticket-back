package com.tow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tow.domain.MainPostTicketDB;
import com.tow.service.MainPostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class MainPostController {
    @Autowired
    private MainPostService mainPostService;
    
    @GetMapping("/home")
	public List<MainPostTicketDB> main() {
		return mainPostService.getAll();
	}
    
    @GetMapping("/home/genre/{genre}")
    public List<MainPostTicketDB> getByGenre(@PathVariable String genre) {
        return mainPostService.getByGenre(genre);
    }
}