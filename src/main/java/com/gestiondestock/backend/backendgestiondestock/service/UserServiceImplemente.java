package com.gestiondestock.backend.backendgestiondestock.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiondestock.backend.backendgestiondestock.entity.User;
import com.gestiondestock.backend.backendgestiondestock.repo.UserRepository;
import com.gestiondestock.backend.enumeration.ETAT_USER;

@Service
public class UserServiceImplemente implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User blockedDate(Long id, String loginAgent) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty())
			return null;

		User userTrouve = user.get();
		userTrouve.setBlockedByAgent(loginAgent);
		userTrouve.setBlockedDate(new Date());
		userTrouve.setEtat(ETAT_USER.INACTIF.toString());

		System.out.println("User blocked "+ userTrouve);
		return userRepository.save(userTrouve);

	}

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
		user.setEtat(ETAT_USER.SUPPRIME.name());
		updateUser(user);
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		User user = getUser(id);
		user.setEtat(ETAT_USER.SUPPRIME.name());
		updateUser( user);
		
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return getUser(id);
	}

}
