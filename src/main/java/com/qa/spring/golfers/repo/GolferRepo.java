package com.qa.spring.golfers.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.spring.golfers.domain.Players;

@Repository
public interface GolferRepo extends JpaRepository<Players, Long> {
	

}

