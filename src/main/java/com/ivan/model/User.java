/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.model;

//import java.sql.Date;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author ivan
 */
@Entity
@Data
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 255)
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 255)
    @Column(name = "lastName")
    private String lastName;

    @Past
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;//Use java.util.date
    //private String dateOfBirth;

    @NotNull
    @Size(min = 2, max = 255)
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @NotNull
    @Email
    @Column(name = "email")
    private String email;//Regex validator

    //No need for id in the constructor since its GeneratedValue - > GenerationType.AUTO
    public User(String firstName, String lastName, Date dateOfBirth, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User() {

    }
}
