package com.secure.securesociety.model.main.outputModel;

import com.secure.securesociety.model.entity.User;
import com.secure.securesociety.model.entity.Visit;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class UserVisitGetOutputModel {

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
    private List<VisitGetOutputModel> visitList = new ArrayList<>();

    public static UserVisitGetOutputModel mapUser(User user, List<VisitGetOutputModel> visitList){
        if(user == null)
            return null;
        UserVisitGetOutputModel userVisitGetOutputModel = new UserVisitGetOutputModel();
        userVisitGetOutputModel.setCity(user.getCity());
        userVisitGetOutputModel.setState(user.getState());
        userVisitGetOutputModel.setCountry(user.getCountry());
        userVisitGetOutputModel.setZipCode(user.getZipCode());
        userVisitGetOutputModel.setCreatedAt(user.getCreatedAt());
        userVisitGetOutputModel.setUpdatedAt(user.getUpdatedAt());
        userVisitGetOutputModel.setEmail(user.getEmail());
        userVisitGetOutputModel.setMobileNumber(user.getMobileNumber());
        userVisitGetOutputModel.setFirstName(user.getFirstName());
        userVisitGetOutputModel.setLastName(user.getLastName());
        userVisitGetOutputModel.setId(user.getId());
        userVisitGetOutputModel.setStatus(user.getStatus());
        userVisitGetOutputModel.setAllowPass(user.isAllowPass());
        userVisitGetOutputModel.setLatestVisit(user.getLatestVisit());
        if(visitList != null)
            userVisitGetOutputModel.setVisitList(visitList);
        return userVisitGetOutputModel;
    }
}
