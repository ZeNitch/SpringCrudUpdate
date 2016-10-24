/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.service;

import com.ivan.model.User;
import com.ivan.repository.UserRepository;
import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ivan
 */
@Service("repoDB")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //RequestMethod.GET //vzimane na informaciq
    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    //RequestMethod.Get //Vzimane na informaciq
    @Override
    public User getSpecificUser(Long id) {
        return userRepository.findOne(id);
    }

    //RequestMethod.POST //Dobavqne na nova informaciq
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    //RequestMethod.DELETE //Iztrivane na informaciq
    @Override
    public Collection<User> deleteUser(Long id) {
        userRepository.delete(id);
        return userRepository.findAll();
    }

    //RequestMethod.PUT //Obnovqvane na stara informaciq s nova
    @Override
    public User updateUser(User user) {
        User userCup = userRepository.findOne(user.getId());
        if (userCup != null) {
            userCup.setFirstName(user.getFirstName());
            userCup.setLastName(user.getLastName());
            userCup.setDateOfBirth(user.getDateOfBirth());
            userCup.setPhoneNumber(user.getPhoneNumber());
            userCup.setEmail(user.getEmail());
            return userRepository.save(user);
        }
        return null;

    }

    //RequestMethod.GET //Vzimane na informaciq
    @Override
    public Collection<User> sortByLastName() {
        return userRepository.sortByLastName();
    }

    //RequestMethod.GET //Vzimane na informaciq
    @Override
    public Collection<User> sortByDateOfBirth() {
        return userRepository.sortByDateOfBirth();
    }

    //RequestMethod.GET //Vzimane na informaciq
    @Override
    public Collection<User> search(String parameter) {

        return userRepository.search(parameter.toUpperCase());
    }
}
