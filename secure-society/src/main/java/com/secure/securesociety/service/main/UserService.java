package com.secure.securesociety.service.main;

import com.secure.securesociety.framework.model.ResponseModel;
import com.secure.securesociety.model.entity.User;
import com.secure.securesociety.model.entity.Visit;
import com.secure.securesociety.model.main.inputModel.UserSaveInputModel;
import com.secure.securesociety.model.main.inputModel.UserUpdateInputModel;
import com.secure.securesociety.model.main.outputModel.UserGetOutputModel;
import com.secure.securesociety.model.main.outputModel.UserVisitGetOutputModel;
import com.secure.securesociety.model.main.outputModel.VisitGetOutputModel;
import com.secure.securesociety.repo.UserRepo;
import com.secure.securesociety.service.main.impl.IUserService;
import com.secure.securesociety.utils.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo repository;

    @Autowired
    private VisitService visitService;

    public ResponseModel saveUser(UserSaveInputModel inputModel) {
        if(inputModel != null){
            if(inputModel.getMobileNumber() != null) {
                if(repository.existsByMobileNumber(inputModel.getMobileNumber())){
                    return new ResponseModel(null, "mobile number already exist");
                }
            }
            if(inputModel.getEmail() != null) {
                if(repository.existsByEmail(inputModel.getEmail())){
                    return new ResponseModel(null, "email already exist");
                }
            }
            return new ResponseModel(repository.save(UserSaveInputModel.mapUser(inputModel)), "saved successfully");
        }
        return new ResponseModel(null, "input cannot be null");
    }

    public List<UserGetOutputModel> getUsers() {
        List<UserGetOutputModel> userGetOutputModelList = new ArrayList<>();
        repository.findAll().forEach(obj -> {
            userGetOutputModelList.add(UserGetOutputModel.mapUser(obj));
        });
        return userGetOutputModelList;
    }

    public List<UserGetOutputModel> findEnteringUsers(String status) {
        List<UserGetOutputModel> userGetOutputModelList = new ArrayList<>();
        repository.findByStatus(status).forEach(obj -> {
            userGetOutputModelList.add(UserGetOutputModel.mapUser(obj));
        });
        return userGetOutputModelList;
    }

    public UserGetOutputModel getUserById(int id) {
        return UserGetOutputModel.mapUser(repository.findById(id).orElse(null));
    }

    public UserGetOutputModel getUserByName(String name) {
        return UserGetOutputModel.mapUser(repository.findByFirstName(name));

    }

    public UserGetOutputModel getUserByPhone(String name) {
        return UserGetOutputModel.mapUser(repository.findByMobileNumber(name));
    }

    public ResponseModel getUserVisitByUserId(int userId){
        User user = repository.findById(userId).orElse(null);
        if (user == null)
            return new ResponseModel("User does not exist");
        List<VisitGetOutputModel> visitGetOutputModelList = visitService.getVisitByUserId(userId);
        UserVisitGetOutputModel outputModel = UserVisitGetOutputModel.mapUser(user, visitGetOutputModelList);
        return new ResponseModel(outputModel, "Data fetch successfully");
    }

    public UserGetOutputModel getUserByEmail(String email) {
        return UserGetOutputModel.mapUser(repository.findByEmail(email));
    }

    public String deleteUser(int id) {
        repository.deleteById(id);
        return "User removed !! " + id;
    }

    public ResponseModel updateUser(UserUpdateInputModel inputModel) {
        User existingUser = repository.findById(inputModel.getId()).orElse(null);
        if(inputModel == null)
            return new ResponseModel(null, "input cannot be null");
        if(existingUser != null) {
            existingUser.setFirstName(inputModel.getFirstName());
            existingUser.setAllowPass(inputModel.isAllowPass());
            existingUser.setUpdatedAt(DateUtility.getTime());
            return new ResponseModel(repository.save(existingUser), "");
        }
        return new ResponseModel(null, "user does not exist");
    }
}
