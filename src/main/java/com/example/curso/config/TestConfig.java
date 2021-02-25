package com.example.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.curso.entities.User;
import com.example.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository; //constructor;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria", "maria@gmail.com", "999998888" , "123123");
		User u2 = new User(null, "Maria", "maria@gmail.com", "999998888" , "32232");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		
	}
	
	// metodo run executa sempre que o programa inicializar
	
	
	
	
	
}
