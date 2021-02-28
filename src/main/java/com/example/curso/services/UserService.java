package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.entities.User;
import com.example.curso.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		
		return obj.get();
	}
	
	public User insert(User user) {		
		return userRepository.save(user);		
	}
	
	public void delete(Long id) {
		User obj = findById(id);
		userRepository.delete(obj);			
	}
	
	public User updateUser(Long id, User obj) {
		User entity = userRepository.getOne(id); 
		
		updateData(entity, obj);
		
		return userRepository.save(entity);
	}

	private void updateData(User entity, User obj) {		
		entity.setName(obj.getEmail());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
