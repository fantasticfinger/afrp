package com.nbp.afrp.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nbp.afrp.Login.UserRepository;
import com.nbp.afrp.Model.Account;
import com.nbp.afrp.Model.Game;
import com.nbp.afrp.Model.Team;
import com.nbp.afrp.Repository.AccountRepository;
import com.nbp.afrp.Repository.GameRepository;
import com.nbp.afrp.Repository.TeamRepository;

@CrossOrigin (origins = "*")
@RestController
@RequestMapping(path = "/team")
public class TeamController {
	
	@Autowired
	private TeamRepository teamRepository;
	@Autowired 
	private AccountRepository accountRepository;
	
	
	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public List<Team> searchTeam(@RequestParam String team ) {
		System.out.println(">>:" + team);
		if(team.equals("")) {
			return teamRepository.findAll();		
		}
		else {
			return teamRepository.findByTeamname(team);
		}
	}
	
	
//	@RequestMapping(value = "/team", method = RequestMethod.GET)
//	public Team myTeam2(@RequestParam String team ) {
//		if(team.equals(""))
//		System.out.println(">>:" + team);
//		
//		Object myId = SecurityContextHolder.getContext().getAuthentication().getPrincipal();	
//		System.out.println((String)myId);
//		Account acc = accountRepository.findBymyId((String)myId);
//		String myTeam = acc.getTeam_name();
//		return teamRepository.findByteam_name(myTeam);
//	}
	
	
	
}
