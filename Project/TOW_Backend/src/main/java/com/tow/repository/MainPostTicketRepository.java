package com.tow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tow.domain.MainPostTicketDB;

@Repository
public interface MainPostTicketRepository extends JpaRepository<MainPostTicketDB, Integer> {
	List<MainPostTicketDB> findByGenre(String genre);
}
