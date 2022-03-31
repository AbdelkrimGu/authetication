package com.example.userservice;

import com.example.userservice.domain.User;
import com.example.userservice.service.UserService;
import com.example.userservice.domain.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null, "Guenanou Abdelkrim", "guenanou", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Guenanou Abdelkrim1", "guenanou1", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Guenanou Abdelkrim2", "guenanou2", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Guenanou Abdelkrim3", "guenanou3", "1234", new ArrayList<>()));

			userService.addRoleToUser("guenanou", "ROLE_USER");
			userService.addRoleToUser("guenanou1", "ROLE_USER");
			userService.addRoleToUser("guenanou2", "ROLE_ADMIN");
			userService.addRoleToUser("guenanou3", "ROLE_ADMIN");
			userService.addRoleToUser("guenanou3", "ROLE_USER");
		};
	}

}
