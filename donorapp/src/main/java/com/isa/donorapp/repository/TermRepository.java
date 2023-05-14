package com.isa.donorapp.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.donorapp.model.Term;
public interface TermRepository extends JpaRepository<Term, Long> {
	Optional<Term> findById(Integer id);
	List<Term> findByReservedById(Integer reservedById);
}