package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.curso.entities.User;
import com.example.curso.repositories.UserRepository;
import com.example.curso.services.exceptions.DatabaseException;
import com.example.curso.services.exceptions.ResourcerNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourcerNotFoundException(id));
	}

	public User insert(User user) {
		return userRepository.save(user);
	}

	public void delete(Long id) {
		try {
			User obj = findById(id);
			userRepository.delete(obj);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourcerNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User updateUser(Long id, User obj) {
		try {
			User entity = userRepository.getOne(id);
			updateData(entity, obj);
			return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourcerNotFoundException(id);
		}

	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getEmail());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
