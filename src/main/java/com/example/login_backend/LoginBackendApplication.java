package com.example.login_backend;

import com.example.login_backend.entities.Authority;
import com.example.login_backend.entities.User;
import com.example.login_backend.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LoginBackendApplication {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(LoginBackendApplication.class, args);
		System.out.println("Can login!");
	}

///to dbInit
//	@PostConstruct
//	protected void init() {
//
//		List<Authority> authorityList=new ArrayList<>();
//
//		authorityList.add(createAuthority("ADMIN","Admin role"));
//
//		User user=new User();
//
//		user.setUserName("Madura");
//		user.setFirstName("Madura");
//		user.setLastName("Chamodara");
//
//		user.setPassword(passwordEncoder.encode("123456789"));
//		user.setEnabled(true);
//		user.setAuthorities(authorityList);
//
//		userDetailsRepository.save(user);
//
//	}
//
//
//	private Authority createAuthority(String roleCode,String roleDescription) {
//		Authority authority=new Authority();
//		authority.setRoleCode(roleCode);
//		authority.setRoleDescription(roleDescription);
//		return authority;
//	}

//Madura-Admin
//Malik-Member
//Ravindu-P_Coordinator
//pw-123456789

}
