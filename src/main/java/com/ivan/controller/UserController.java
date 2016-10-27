/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.controller;

import com.ivan.model.User;
import com.ivan.service.UserServiceImpl;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ivan
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired //Autowired izpolzva se funkcionalnost na UserServices
    private UserServiceImpl userService;

    //RequestMethod.GET //vzimane na informaciq
    //Pri ednakvi requestMethod-i izpolzvane na razli4ni value. Vij Sortirovki
    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //RequestMethod.Get //Vzimane na informaciq
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public User getSpecificUser(@PathVariable("id") Long id) {
        return userService.getSpecificUser(id);
    }

    //RequestMethod.POST //Dobavqne na nova informaciq //Consumes = MediaType.... za poemane na informaciq ot dhc console + RequestBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    //RequestMethod.DELETE //Iztrivane na informaciq
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    //RequestMethod.PUT //Obnovqvane na stara informaciq s nova //Consumes ^
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    //RequestMethod.GET //Vzimane na informaciq
    @RequestMapping(value = "/sortLName", method = RequestMethod.GET)
    public Collection<User> sortByLastName() {
        return userService.sortByLastName();
    }

    //RequestMethod.GET //Vzimane na informaciq
    @RequestMapping(value = "/sortDoB", method = RequestMethod.GET)
    public Collection<User> sortByDateOfBirth() {
        return userService.sortByDateOfBirth();
    }

    //RequestMethod.GET //Vzimane na informaciq
    @RequestMapping(value = "/search/{parameter}", method = RequestMethod.GET)
    public Collection<User> search(@PathVariable("parameter") String parameter) {
        return userService.search(parameter);
    }
}
