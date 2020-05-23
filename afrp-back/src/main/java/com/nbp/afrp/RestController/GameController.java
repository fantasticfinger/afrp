package com.nbp.afrp.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nbp.afrp.Model.Game;
import com.nbp.afrp.Repository.GameRepository;

@CrossOrigin (origins = "*")
@RestController
public class GameController {
	
	@Autowired
	private GameRepository gameRepository;
	
	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public Collection<Game> gameGetAll() {
		Collection<Game> games = gameRepository.findAll();
		return games;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Game gameAdd(@RequestBody Game game) {
		
		return gameRepository.save(game);
	}
	
	@RequestMapping(value = "/{num}", method = RequestMethod.DELETE)
	public Boolean gameDelete(@PathVariable(value = "num") String num) {
		Optional<Game> game = gameRepository.findById(Long.parseLong(num));
    	if(game == null) {
    		return false;
    	}
    	else {
    		gameRepository.deleteById(Long.parseLong(num));
			return true;
    	}
	}
	
	@RequestMapping(value = "/game", method = RequestMethod.PUT)
	public Game gameUpdate(@RequestBody Game game) {
		System.out.println(game.getAway_team());
		return gameRepository.save(game);

	}
	
}
