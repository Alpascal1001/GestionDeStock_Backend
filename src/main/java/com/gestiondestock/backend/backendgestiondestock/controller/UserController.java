package com.gestiondestock.backend.backendgestiondestock.controller;

import com.gestiondestock.backend.backendgestiondestock.dto.BlockDto;
import com.gestiondestock.backend.backendgestiondestock.dto.UnblockedDto;
import com.gestiondestock.backend.backendgestiondestock.dto.UserDto;
import com.gestiondestock.backend.backendgestiondestock.entity.User;
import com.gestiondestock.backend.backendgestiondestock.service.UserService;
import com.gestiondestock.backend.enumeration.ETAT_USER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/List_users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/userbyid/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {

        //Tester si l'utilisateur est null
        if (user == null) {
            throw new IllegalArgumentException("L'utilisateur passe en argument est null");
        }

        //Tester si l'utilisateur existe dejà pour ne pas le recreer
        if (user.getId_USER() != 0) {
            throw new IllegalArgumentException("L'etat de l'utilisateur ne permet pas de le créer");
        }

        //Tester si tout est ok
        user.setEtat(ETAT_USER.ACTIF.toString());
        user.setCreatedAt(new Date());
        System.out.println("User " + user);
        return userService.createUser(user);
    }

    @PutMapping("/modifUser")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }


    //USAGE D'UN DTO
    @PostMapping("/blockageUser")
    public UserDto blockageUser(@RequestBody UserDto user) {
        return userService.blockageUser(user);
    }

    @PostMapping("/deBlockageUser")
    public UserDto deBlockageUser(@RequestBody UserDto user) {
        return userService.DeblockageUser(user);
    }


    @DeleteMapping("/suprimeUser/{id}")
    public void deleteUser(@PathVariable long id) {

        userService.deleteUserById(id);
    }

//    @PostMapping("/blockedUser/{id}/{loginAgent}/{blockedComment}")
//    public User blockedDate(@PathVariable Long id, @PathVariable String loginAgent, @PathVariable String blockedComment) {
//
//        return userService.blockedDate(id, loginAgent, blockedComment);
//    }

    @PostMapping("/blockedUser")
    public User blockedDate2(@RequestBody BlockDto blockDTO) {
        return userService.blockedDate(blockDTO);
    }

    @PostMapping("/unblockedUser")
    public User UnblockedDate(@RequestBody UnblockedDto unblockedDto) {
        return userService.unblockedDate(unblockedDto);
    }
}
