package com.hcc.utils;

import com.hcc.entities.Authority;
import com.hcc.entities.User;
import com.hcc.repositories.AuthorityRepository;
import com.hcc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class UserDataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepo;

    @Autowired
    AuthorityRepository authRepo;
    @Override
    public void run(String... args) throws Exception {
        loadUserData();
        loadAuthorityData();

    }

    private void loadUserData() {
        if (userRepo.count() == 0) {
            PasswordEncoder pwenc = new BCryptPasswordEncoder();
            String pw = pwenc.encode("asdfasdf");
            User tom = new User(LocalDate.now(), "tom", pw);
            userRepo.save(tom);
        }
    }

    private void loadAuthorityData() {
        if (authRepo.count() == 0) {
//            Authority adm = new Authority("ROLE_ADMIN", userRepo.findByUsername("tom").get());
//            authRepo.save(adm);
            Authority learner = new Authority("ROLE_LEARNER", userRepo.findByUsername("tom").get());
            authRepo.save(learner);
        }
    }
}