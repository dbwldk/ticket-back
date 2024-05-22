package com.tow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tow.domain.TicketDB;

@Repository
public interface TicketRepository extends JpaRepository<TicketDB, Long> {

}
