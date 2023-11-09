package com.gestiondestock.backend.backendgestiondestock;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gestiondestock.backend.backendgestiondestock.entity.User;
import com.gestiondestock.backend.backendgestiondestock.repo.UserRepository;



@SpringBootTest
class BackendgestiondestockApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Test
	public void testCreateUser() {
		User user1= new User("Drame", "Fatoumata", "grdyoff", "778773737", "admin", "fatouma@drame.com", "passer", "actif");
		userRepository.save(user1);
	}
	
	@Test
	public void testFindUser() {
		Optional<User> user=userRepository.findById(10L);
		System.out.println( "user by id : 10--->" + user.toString());
	}
	
	@Test
	public void testUpdateUser() {
		Optional<User> user=userRepository.findById(4L);
		user.get().setNom("DIALLO");
		user.get().setPrenom("Aziz");
		userRepository.save(user.get());
		
	}
	
	
	
	@Test
	public void  testListUser(){
		List<User> users =userRepository.findAll();
		if (users==null) {
			return;
		}else {
		for (User u:users) {
			System.out.println(u.toString());
		}
		}
	}
	

}
