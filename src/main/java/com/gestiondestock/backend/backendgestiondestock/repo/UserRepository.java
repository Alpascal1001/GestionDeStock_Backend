package com.gestiondestock.backend.backendgestiondestock.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestiondestock.backend.backendgestiondestock.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
