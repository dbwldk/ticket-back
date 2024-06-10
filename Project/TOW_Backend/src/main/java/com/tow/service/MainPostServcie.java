package com.tow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tow.domain.MainPostTicketDB;
import com.tow.repository.MainPostRepositroy;

import java.time.LocalDate;
import java.util.List;

@Service
public class MainPostServcie {
    @Autowired
    private MainPostRepositroy ticketReq;
    
    //인기TOP10
    public List<MainPostTicketDB> getTop10() {
        return ticketReq.findTop10();
    }
    
    //Month 월별 10개
    public List<MainPostTicketDB> getTicketsForCurrentMonth(int limit) {
        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();
        int currentMonth = now.getMonthValue();
        return ticketReq.findTicketsForCurrentMonth(currentMonth, currentYear, limit);
    }
    
    //모두 가져오기
    public List<MainPostTicketDB> getAll() {
        return ticketReq.findAll();
    }
}
