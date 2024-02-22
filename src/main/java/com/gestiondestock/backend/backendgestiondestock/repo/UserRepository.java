package com.gestiondestock.backend.backendgestiondestock.repo;

import com.gestiondestock.backend.backendgestiondestock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM `user` WHERE user.etat = 'ACTIF';", nativeQuery = true)
    List<User> findUserActifs();
    
}