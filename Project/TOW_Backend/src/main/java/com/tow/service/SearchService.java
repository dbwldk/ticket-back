package com.tow.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tow.domain.SearchTicketDB;
import com.tow.repository.SearchTicketRepository;

@Service
public class SearchService {
	@Autowired
	private SearchTicketRepository sticketRep;
	
	public Date convertStringToSqlDate(String dateString) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		java.util.Date parseDate = dateFormat.parse(dateString);
		return new java.sql.Date(parseDate.getTime());
	}
	
	public Page<SearchTicketDB> findPageByFilters(List<String> regionList, List<String> genreList,
			Date startDate, Date endDate, String searchKeyword,
			Pageable pageable) {
		return sticketRep.findPageByFilters(regionList, genreList, startDate, endDate, searchKeyword, pageable);
	}
}
