package com.nbp.afrp.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nbp.afrp.Login.User;
import com.nbp.afrp.Model.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{
//	@Query("SELECT team From Team team where team.team_name =:team_name")
//	@Transactional(readOnly = true)
//	List<Team> findByteam_name(@Param("team_name") String team_name);

	List<Team> findByTeamname(String team_name);
}
