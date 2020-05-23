package com.nbp.afrp.Repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nbp.afrp.Model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	//ID찾기
	@Query("SELECT user From User user where user.id =:id")
	@Transactional(readOnly = true)
	Account findBymyId(@Param("id") String id);
	
	@Query("SELECT user.id From User user where user.id =:id")
	@Transactional(readOnly = true)
	ArrayList<String> findByJoinId(@Param("id") String id);
	
	
	Account save(Account user);
}
