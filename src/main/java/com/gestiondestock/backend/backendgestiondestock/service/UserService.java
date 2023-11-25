package com.gestiondestock.backend.backendgestiondestock.service;

import java.util.List;

import com.gestiondestock.backend.backendgestiondestock.entity.User;

public interface UserService {
	
	User saveUser(User user);
	User updateUser(User user);
	void deleteUser(User user);
	void deleteUserById(Long id);
	User getUser(Long id);
	List<User> getAllUsers();
	User createUser(User user);
	User getUserById(long id);

}
