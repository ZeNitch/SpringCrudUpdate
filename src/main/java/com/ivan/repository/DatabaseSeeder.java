/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.repository;

import com.ivan.model.Account;
import com.ivan.model.AccountRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author ivan
 */
@Component
public class DatabaseSeeder implements CommandLineRunner {//run at start

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... strings) throws Exception {
        //Add user at the start of the application
        //User user = new User("Test", "LastName", new Date(725846400000L), "123", "test@test");
        //Used for testing
        //userRepository.save(user);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        String usrEncodePass = encoder.encode("rupsi");
        String admEncodePass = encoder.encode("123");
        String modEncodePass = encoder.encode("asd");

        Account usr = new Account("usr", usrEncodePass, AccountRole.USER);
        Account usrMod = new Account("mod", modEncodePass, AccountRole.MODERATOR);
        Account usrAdm = new Account("root", admEncodePass, AccountRole.ADMIN);
        accountRepository.save(usr);
        accountRepository.save(usrMod);
        accountRepository.save(usrAdm);
    }

}
