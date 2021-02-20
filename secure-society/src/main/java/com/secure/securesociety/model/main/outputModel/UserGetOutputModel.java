package com.secure.securesociety.model.main.outputModel;

import com.secure.securesociety.model.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class UserGetOutputModel {

    private int id;
    private String mobileNumber;
    private String firstName;
    private String lastName;
    private String email;
    private Date createdAt;
    private Date updatedAt;
    private String city;
    private String state;
    private String country;
    private int zipCode;
    private String status;
    private boolean allowPass;
    private int latestVisit;

    public static UserGetOutputModel mapUser(User user){
        if(user == null)
            return null;
        UserGetOutputModel userGetOutputModel = new UserGetOutputModel();
        userGetOutputModel.setCity(user.getCity());
        userGetOutputModel.setState(user.getState());
        userGetOutputModel.setCountry(user.getCountry());
        userGetOutputModel.setZipCode(user.getZipCode());
        userGetOutputModel.setCreatedAt(user.getCreatedAt());
        userGetOutputModel.setUpdatedAt(user.getUpdatedAt());
        userGetOutputModel.setEmail(user.getEmail());
        userGetOutputModel.setMobileNumber(user.getMobileNumber());
        userGetOutputModel.setFirstName(user.getFirstName());
        userGetOutputModel.setLastName(user.getLastName());
        userGetOutputModel.setId(user.getId());
        userGetOutputModel.setStatus(user.getStatus());
        userGetOutputModel.setAllowPass(user.isAllowPass());
        userGetOutputModel.setLatestVisit(user.getLatestVisit());
        return userGetOutputModel;
    }
}
