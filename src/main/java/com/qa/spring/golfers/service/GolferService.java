package com.qa.spring.golfers.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.spring.golfers.domain.Players;
import com.qa.spring.golfers.repo.GolferRepo;


import java.util.List;

@Service  //handles business logic

public class GolferService {
	
//	Dependency
	
	public GolferRepo repo;
	
	public GolferService(GolferRepo repo ) {
		this.repo = repo;
	}
	
// Create the methods for the interaction between controller & repo
	
	// CREATE
	public Players create(Players player) {
		return this.repo.saveAndFlush(player);
	}
	
//	// READ
	public List<Players> read(){
		return this.repo.findAll(); 
	}

//	// UPDATE
		public Players update(Long id, Players newPlayer) {
//			// GET THE RECORD THAT LIVES IN THE DB
			Players existing = this.repo.getById(id); 
			existing.setPlayerName(newPlayer.getPlayerName());
			existing.setHomeCourse(newPlayer.getHomeCourse());
			existing.setMajorsWon(newPlayer.getMajorsWon());
			existing.setLegend(newPlayer.isLegend());
			Players updated = this.repo.save(existing);
			return updated;
		}
			
			
		// DELETE
		public boolean delete(Long id) {
			this.repo.deleteById(id);
			return this.repo.existsById(id); 
			
		}
			
		}
	
	
	
	

