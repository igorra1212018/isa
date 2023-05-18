package com.isa.donorapp.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.donorapp.model.Reservation;
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	Optional<Reservation> findById(Integer id);
	List<Reservation> findByUserId(Integer userId);
	List<Reservation> findByTermId(Integer termId);
}