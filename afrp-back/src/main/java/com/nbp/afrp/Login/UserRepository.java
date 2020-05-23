package com.nbp.afrp.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT user From User user where user.id =:id")
	@Transactional(readOnly = true)
	User findBymyId(@Param("id") String id);
}