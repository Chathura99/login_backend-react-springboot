package com.example.login_backend.repository;
//UserDetailsRepository
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login_backend.entities.User;

//link userRepository with UserDetailsService interface
@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);
	
}
