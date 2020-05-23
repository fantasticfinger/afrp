package com.nbp.afrp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nbp.afrp.Model.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	
}
