package com.gestiondestock.backend.backendgestiondestock;

import com.gestiondestock.backend.backendgestiondestock.entity.User;
import com.gestiondestock.backend.backendgestiondestock.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class BackendgestiondestockApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        User user1 = new User("Sene", "Makhoudia", "grdyoff", "778773737", "admin", "fatouma@drame.com", "passer", "actif");
        userRepository.save(user1);
    }

    @Test
    public void testFindUser() {
        Optional<User> user = userRepository.findById(10L);
        System.out.println("user by id : 10--->" + user);
    }

    @Test
    public void testUpdateUser() {
        Optional<User> user = userRepository.findById(1L);
        user.get().setNom("DIALLO");
        user.get().setPrenom("Aziz");
        userRepository.save(user.get());

    }


    @Test
    public void testListUser() {
        List<User> users = userRepository.findAll();
        if (users == null) {

        } else {
            for (User u : users) {
                System.out.println(u.toString());
            }
        }
    }


}
