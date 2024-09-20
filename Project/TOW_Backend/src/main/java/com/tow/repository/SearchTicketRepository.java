package com.tow.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tow.domain.SearchTicketDB;

@Repository
public interface SearchTicketRepository extends JpaRepository<SearchTicketDB, Integer> {
	@Query("SELECT s FROM SearchTicketDB s " +
			"WHERE (:regionList IS NULL OR s.region IN :regionList) " +
			"AND (:genreList IS NULL OR s.genre IN :genreList) " +
			"AND (:startDate IS NULL OR :endDate IS NULL OR (s.event_start_date <= :endDate AND s.event_end_date >= :startDate)) "+
			"AND (:searchKeyword IS NULL OR s.event_name LIKE %:searchKeyword%)")
	Page<SearchTicketDB> findPageByFilters(
			@Param("regionList") List<String> regionList,
            @Param("genreList") List<String> genreList,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate,
            @Param("searchKeyword") String searchKeyword,
            Pageable pageable);
}
