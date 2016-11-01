/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.repository;

import com.ivan.model.User;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ivan
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /*@Query("select u from User u order by ?1")
    Collection<User> sortBy(String parameter);*/
    @Query("select u from User u order by lastName")
    Collection<User> sortByLastName();

    @Query("select u from User u order by dateOfBirth")
    Collection<User> sortByDateOfBirth();

    @Query("select u from User u where "
            + "upper(u.firstName) like concat('%', ?1, '%') or "
            + "upper(u.lastName) like concat('%', ?1, '%') or "
            + "upper(u.phoneNumber) like concat('%', ?1, '%') or "
            + "upper(u.email) like concat('%', ?1, '%')")
    Collection<User> search(String value);

    List<User> findByFirstNameContainingOrLastNameContainingOrPhoneNumberContainingOrEmailContainingAllIgnoreCase(String pOne, String pTwo, String pThree, String pFour);
    /*@Query("select u from User u where u.?1 = ?2")
    Collection<User> searchByParameter(String column, String value);*/
}
