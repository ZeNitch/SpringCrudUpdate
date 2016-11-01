/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.service;

import com.ivan.model.User;
import java.util.Collection;

/**
 *
 * @author ivan
 */
public interface UserService {

    //RequestMethod.POST //Dobavqne na nova informaciq
    User addUser(User user);

    //RequestMethod.DELETE //Iztrivane na informaciq
    Collection<User> deleteUser(Long id);

    //RequestMethod.GET //vzimane na informaciq
    Collection<User> getAllUsers();

    //RequestMethod.Get //Vzimane na informaciq
    User getSpecificUser(Long id);

    //RequestMethod.GET //Vzimane na informaciq
    Collection<User> search(String parameter);

    //Collection<User> search(String parameter);
    //RequestMethod.GET //Vzimane na informaciq
    Collection<User> sortByDateOfBirth();

    //RequestMethod.GET //Vzimane na informaciq
    Collection<User> sortByLastName();

    //RequestMethod.PUT //Obnovqvane na stara informaciq s nova
    User updateUser(User user);

}
