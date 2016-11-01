/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.security;

import com.ivan.model.Account;
import com.ivan.model.AccountRole;
import com.ivan.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author ivan
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    AccountRepository accountRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/usr/**").hasAnyRole(AccountRole.USER.toString(), AccountRole.MODERATOR.toString(), AccountRole.ADMIN.toString())
                .antMatchers("/create/**", "/update/**").hasAnyRole(AccountRole.MODERATOR.toString(), AccountRole.ADMIN.toString())
                .antMatchers("/delete/**").hasRole(AccountRole.ADMIN.toString())
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/usr", true)
                .permitAll()
                .and()
                .rememberMe();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        for (Account acc : accountRepository.findAll()) {
            auth
                    .inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder(12))
                    .withUser(acc.getUsername()).password(acc.getPassword()).roles(acc.getAccRole().toString());
        }
    }
}
