package com.gestiondestock.backend.backendgestiondestock.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        user.setEtat(ETAT_USER.ACTIF.toString());
        user.setCreatedAt(new Date());
         System.out.println("User "+ user.toString());
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

    @PostMapping("blockedUser/{id}/{loginAgent}")
    public User blockedDate(@PathVariable Long id, @PathVariable String loginAgent){

        return userService.blockedDate(id, loginAgent);
    }
}
