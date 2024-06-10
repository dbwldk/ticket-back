package com.tow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tow.domain.TicketDB;

@Repository
public interface TicketRepository extends JpaRepository<TicketDB, Integer> {
	@Query("SELECT t FROM TicketDB t LEFT JOIN FETCH t.eventSites e WHERE t.id = :ticketId")
	Optional<TicketDB> findTicketAndSites(@Param("ticketId") Integer ticketId);
	
	@Query("SELECT t FROM TicketDB t WHERE " +
			"t.address LIKE :keyword%")
	List<TicketDB> findByAddrLimitTop(
			@Param("keyword") String keyword,
            Pageable pageable);
}
