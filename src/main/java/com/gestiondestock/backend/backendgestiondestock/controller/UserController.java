package com.gestiondestock.backend.backendgestiondestock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestiondestock.backend.backendgestiondestock.entity.User;
import com.gestiondestock.backend.backendgestiondestock.service.UserService;
import com.gestiondestock.backend.enumeration.ETAT_USER;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

 

    @GetMapping
    @RequestMapping("List_users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    

    @GetMapping("/userbyid/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

     @PostMapping("createUser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

      @PutMapping("modifUser")
    public User updateUser( @RequestBody User user) {
        return userService.updateUser( user);
    }

       @DeleteMapping("suprimeUser/{id}")
    public void deleteUser(@PathVariable long id) {
        
    	    userService.deleteUserById(id);
    }
}
