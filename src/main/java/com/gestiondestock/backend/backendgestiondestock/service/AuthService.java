package com.gestiondestock.backend.backendgestiondestock.service;

import com.gestiondestock.backend.backendgestiondestock.dto.UserDto;
import com.gestiondestock.backend.backendgestiondestock.entity.User;
import com.gestiondestock.backend.backendgestiondestock.repo.UserRepository;
import com.gestiondestock.backend.enumeration.ETAT_USER;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Log4j2
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public UserDto signUp(UserDto registrationRequest) {
        UserDto userDtoResp = new UserDto();

        try {
            User ourusers = new User();
            ourusers.setPrenom(registrationRequest.getPrenom());
            ourusers.setNom(registrationRequest.getNom());
            ourusers.setContact(registrationRequest.getContact());
            ourusers.setLogin(registrationRequest.getLogin());
            ourusers.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            ourusers.setRole(registrationRequest.getRole());
            ourusers.setEtat(ETAT_USER.ACTIF.toString());

            User ourusersResult = userRepository.save(ourusers);
            if (ourusersResult != null && ourusersResult.getId_USER() > 0) {
                userDtoResp.setUsers(ourusersResult);
                userDtoResp.setMessage("User Saved Successfully !");
                userDtoResp.setStatusCode(200);

            }
        } catch (Exception e) {
            userDtoResp.setStatusCode(500);
            userDtoResp.setError(e.getMessage());
        }

        return userDtoResp;
    }

    public UserDto signIn(UserDto signinRequest) {
        UserDto response = new UserDto();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getLogin(), signinRequest.getPassword()));
            var user = userRepository.findByLogin(signinRequest.getLogin()).orElseThrow();
            System.out.println("USER IS: " + user);
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Signed In");
        } catch (Exception e) {
            log.error("Erreurs", e);
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }

    public UserDto refreshToken(UserDto refreshTokenRequest) {
        UserDto response = new UserDto();

        String ourEmail = jwtUtils.extractUsername(refreshTokenRequest.getToken());
        User users = userRepository.findByLogin(ourEmail).orElseThrow();
        if (jwtUtils.isTokenValid(refreshTokenRequest.getToken(), users)) {
            var jwt = jwtUtils.generateToken(users);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenRequest.getToken());
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Refresh Token");

        }
        response.setStatusCode(500);
        return response;
    }
}
