package com.secure.securesociety.service.main.impl;

import com.secure.securesociety.framework.model.ResponseModel;
import com.secure.securesociety.model.entity.User;
import com.secure.securesociety.model.main.inputModel.UserSaveInputModel;
import com.secure.securesociety.model.main.inputModel.UserUpdateInputModel;
import com.secure.securesociety.model.main.outputModel.UserGetOutputModel;
import com.secure.securesociety.model.main.outputModel.UserVisitGetOutputModel;

import java.util.List;

public interface IUserService {

    ResponseModel saveUser(UserSaveInputModel user);

    List<UserGetOutputModel> getUsers();

    List<UserGetOutputModel> findEnteringUsers(String status);

    UserGetOutputModel getUserById(int id);

    UserGetOutputModel getUserByName(String name);

    UserGetOutputModel getUserByPhone(String name);

    ResponseModel getUserVisitByUserId(int userId);

    UserGetOutputModel getUserByEmail(String email);

    String deleteUser(int id);

    ResponseModel updateUser(UserUpdateInputModel User);
}
