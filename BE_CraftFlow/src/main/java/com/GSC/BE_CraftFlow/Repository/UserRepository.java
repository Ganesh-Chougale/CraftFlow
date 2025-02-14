package com.GSC.BE_CraftFlow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GSC.BE_CraftFlow.Modal.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
