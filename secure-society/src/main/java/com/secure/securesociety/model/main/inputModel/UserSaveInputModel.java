package com.secure.securesociety.model.main.inputModel;

import com.secure.securesociety.model.entity.User;
import com.secure.securesociety.model.main.outputModel.UserVisitGetOutputModel;
import com.secure.securesociety.model.main.outputModel.VisitGetOutputModel;
import com.secure.securesociety.utils.DateUtility;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserSaveInputModel {

    private String mobileNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String state;
    private String country;
    private int zipCode;
    private boolean allowPass;

    public static User mapUser(UserSaveInputModel inputModel){
        if(inputModel == null)
            return null;
        User user = new User();
        user.setCity(inputModel.getCity());
        user.setState(inputModel.getState());
        user.setCountry(inputModel.getCountry());
        user.setZipCode(inputModel.getZipCode());
        user.setEmail(inputModel.getEmail());
        user.setMobileNumber(inputModel.getMobileNumber());
        user.setFirstName(inputModel.getFirstName());
        user.setLastName(inputModel.getLastName());
        user.setAllowPass(inputModel.isAllowPass());
        user.setCreatedAt(DateUtility.getTime());
        user.setUpdatedAt(DateUtility.getTime());

        return user;
    }
}
