package com.tow.controller;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tow.domain.SearchTicketDB;
import com.tow.service.SearchService;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class SearchController {
	@Autowired
	private SearchService searchService;
	
	@GetMapping("testtt")
	public List<SearchTicketDB> testtt() {
		//지역
		List<String> regionList = new ArrayList<>();
		regionList.add("서울");
		regionList.add("경기");
		
		//검색어
		String searchKey = "회";
		
		//기간
		/*
		String startDateString = "2024.05.04";
		String endDateString = "2024.10.11";
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = searchService.convertStringToSqlDate(startDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			endDate = searchService.convertStringToSqlDate(endDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		return searchService.testSearchResult(regionList, null, null, null, searchKey);
	}
	
}
