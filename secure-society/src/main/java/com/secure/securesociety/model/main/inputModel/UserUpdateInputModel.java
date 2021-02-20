package com.secure.securesociety.model.main.inputModel;

import lombok.Data;

import java.util.Date;

@Data
public class UserUpdateInputModel {

    private int id;
    private String mobileNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String state;
    private String country;
    private int zipCode;
    private String status;
    private boolean allowPass;
}
