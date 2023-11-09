package com.gestiondestock.backend.backendgestiondestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiondestock.backend.backendgestiondestock.entity.User;
import com.gestiondestock.backend.backendgestiondestock.repo.UserRepository;

@Service
public class UserServiceImplemente implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
