package com.example.userservice;

import com.example.userservice.domain.User;
import com.example.userservice.enume.Sexe;
import com.example.userservice.service.UserService;
import com.example.userservice.domain.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.Arrays;

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

			userService.saveUser(new User(null, "Guenanou", "Abdelkrim", "0666168243", "a.guenanou@esi-sba.dz", "1234", "c:/images/guenaou", "makam echahid", "sidi bel abbes", Sexe.Homme,   new ArrayList<>()));
			userService.saveUser(new User(null, "Guenanou1", "Abdelkrim1", "0666168244", "a.guenanou1@esi-sba.dz", "1234", "c:/images/guenaou", "makam echahid", "sidi bel abbes", Sexe.Homme,   new ArrayList<>()));
			userService.saveUser(new User(null, "Guenanou2", "Abdelkrim2", "0666168245", "a.guenanou2@esi-sba.dz", "1234", "c:/images/guenaou", "makam echahid", "sidi bel abbes", Sexe.Homme,   new ArrayList<>()));
			userService.saveUser(new User(null, "Guenanou3", "Abdelkrim3", "0666168246", "a.guenanou3@esi-sba.dz", "1234", "c:/images/guenaou", "makam echahid", "sidi bel abbes", Sexe.Homme,   new ArrayList<>()));


			userService.addRoleToUser("a.guenanou@esi-sba.dz", "ROLE_USER");
			userService.addRoleToUser("a.guenanou1@esi-sba.dz", "ROLE_USER");
			userService.addRoleToUser("a.guenanou2@esi-sba.dz", "ROLE_ADMIN");
			userService.addRoleToUser("a.guenanou3@esi-sba.dz", "ROLE_ADMIN");
			userService.addRoleToUser("a.guenanou3@esi-sba.dz", "ROLE_USER");
		};
	}


	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin" , "Access-Control-Allow-Origin" ,"Content-Type" ,
				"Accept" , "Jwt-Token", "Authorization", "Origin, Accept" , "X-Requested-With" ,
				"Access-Control-Request-Method" , "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Type","Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin" ,"Access-Control-Allow-Origin" ,"Access-Control-Allow-Credentials" , "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","PATCH","DELETE","OPTIONS" ));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
		CorsFilter corsFilter = new CorsFilter(urlBasedCorsConfigurationSource);
		return corsFilter;
	}

}
