package com.tow.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tow.domain.ReservationDB;

public interface ReservationRepository extends JpaRepository<ReservationDB, Integer> {
}
