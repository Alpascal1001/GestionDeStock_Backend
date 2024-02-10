package com.gestiondestock.backend.backendgestiondestock.service;

import com.gestiondestock.backend.backendgestiondestock.dto.BlockDto;
import com.gestiondestock.backend.backendgestiondestock.dto.UnblockedDto;
import com.gestiondestock.backend.backendgestiondestock.dto.UserDto;
import com.gestiondestock.backend.backendgestiondestock.entity.User;
import com.gestiondestock.backend.backendgestiondestock.repo.UserRepository;
import com.gestiondestock.backend.enumeration.ETAT_USER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplemente implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User blockedDate(BlockDto blockDto) {
        Optional<User> user = userRepository.findById(blockDto.getIdUser());
        if (user.isEmpty())
            return null;

        User userTrouve = user.get();
        userTrouve.setBlockedByAgent(blockDto.getLoginAgent());
        userTrouve.setBlockedDate(new Date());
        userTrouve.setEtat(ETAT_USER.INACTIF.toString());
        userTrouve.setBlockedComment(blockDto.getComment());

        System.out.println("User blocked " + userTrouve);
        return userRepository.save(userTrouve);

    }

    @Override
    public User unblockedDate(UnblockedDto unblockedDto) {
        Optional<User> user = userRepository.findById(unblockedDto.getIdUser());

        if (user.isEmpty()) {
            return null;
        }

        User userFound = user.get();
        userFound.setUnblockedByAgent(unblockedDto.getLoginAgent());
        userFound.setUnblockedDate(new Date());
        userFound.setUnblockedComment(unblockedDto.getComment());
        userFound.setEtat(ETAT_USER.ACTIF.toString());
        return userRepository.save(userFound);
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

    //USAGE D'UN DTO
    @Override
    public UserDto blockageUser(UserDto user) {
        Optional<User> userFromDB = userRepository.findById(user.getIdUser());
        if (userFromDB.isEmpty())
            return null;

        User userTrouve = userFromDB.get();
        userTrouve.setBlockedByAgent(user.getLoginBlockedAgent());
        userTrouve.setBlockedDate(new Date());
        userTrouve.setUnblockedDate(user.getUnblockedDate());
        userTrouve.setEtat(ETAT_USER.INACTIF.toString());
        userTrouve.setBlockedComment(user.getComentBlockedAgent());

        System.out.println("User blocked " + userTrouve);
        userRepository.save(userTrouve);
        return user;
    }

    @Override
    public UserDto DeblockageUser(UserDto user) {
        Optional<User> userFromDB = userRepository.findById(user.getIdUser());

        if (userFromDB.isEmpty()) {
            return null;
        }

        User userFound = userFromDB.get();
        userFound.setUnblockedByAgent(user.getLoginUnblockedAgent());
        userFound.setUnblockedDate(new Date());
        userFound.setUnblockedComment(user.getComentUnBlockedAgent());
        userFound.setEtat(ETAT_USER.ACTIF.toString());
        userRepository.save(userFound);
        return user;
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
        updateUser(user);

    }

    @Override
    public User getUser(Long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return userRepository.findUserActifs();
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
