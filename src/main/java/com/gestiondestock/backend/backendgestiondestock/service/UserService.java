package com.gestiondestock.backend.backendgestiondestock.service;

import com.gestiondestock.backend.backendgestiondestock.dto.BlockDto;
import com.gestiondestock.backend.backendgestiondestock.dto.UnblockedDto;
import com.gestiondestock.backend.backendgestiondestock.dto.UserDto;
import com.gestiondestock.backend.backendgestiondestock.entity.User;

import java.util.List;

public interface UserService {


    User saveUser(User user);

    User updateUser(User user);

    UserDto blockageUser(UserDto user);

    UserDto DeblockageUser(UserDto user);

    void deleteUser(User user);

    void deleteUserById(Long id);

    User getUser(Long id);

    List<User> getAllUsers();

    User createUser(User user);

    User getUserById(long id);

    User blockedDate(BlockDto blockDto);

    User unblockedDate(UnblockedDto unblockedUser);


}


