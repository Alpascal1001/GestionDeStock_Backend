package com.gestiondestock.backend.backendgestiondestock.service.getUserAuth;


import com.gestiondestock.backend.backendgestiondestock.entity.User;
import com.gestiondestock.backend.backendgestiondestock.repo.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Log4j2
public class GetUserAuthServiceImpl implements GetUserAuthService {


    @Autowired
    UserRepository userRepository;


    //Functioin nous permettant de trouver l'utilisateur connecté
    @Override
    public User getAuthenticate() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("AUTH ::: {}", auth);
        if (Objects.isNull(auth) || AnonymousAuthenticationToken.class.isAssignableFrom(auth.getClass())) {
            return null;
        }
        //
        log.info("AUTH NAME::: {}", auth.getName());
        Optional<User> userConnecte = userRepository.findByLogin(auth.getName());
        log.info("USER CONNECT::: {}", userConnecte);

        return userConnecte.orElse(null);
    }
}
