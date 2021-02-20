package com.secure.securesociety.controller.main;

import com.secure.securesociety.framework.model.ApiResultModel;
import com.secure.securesociety.framework.model.ResponseModel;
import com.secure.securesociety.model.main.inputModel.UserSaveInputModel;
import com.secure.securesociety.model.main.inputModel.UserUpdateInputModel;
import com.secure.securesociety.model.main.outputModel.UserGetOutputModel;
import com.secure.securesociety.service.main.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/secureSociety")
public class UserController {

    @Autowired
    private IUserService service;

    @PostMapping("/user")
    public ResponseEntity<ApiResultModel>  addUser(@RequestBody UserSaveInputModel user) {
        try{
            ResponseModel response = service.saveUser(user);
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(false, response.getMsg(), response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(true, e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    
    @GetMapping("/users")
    public ResponseEntity<ApiResultModel> findAllUsers() {
        try{
            List<UserGetOutputModel> response = service.getUsers();
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(false, "Fetch data successfully", response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(true, e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/userByStatus/{status}")
    public ResponseEntity<ApiResultModel> findUsersByStatus(String status) {
        try{
            List<UserGetOutputModel> response = service.findEnteringUsers(status);
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(false, "Fetch data successfully", response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(true, e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/userById/{id}")
    public ResponseEntity<ApiResultModel> findUserById(@PathVariable int id) {
        try{
            UserGetOutputModel response = service.getUserById(id);
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(false, "Fetch data successfully", response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(true, e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/userByName/{name}")
    public ResponseEntity<ApiResultModel> findUserByName(@PathVariable String name) {
        try{
            UserGetOutputModel response = service.getUserByName(name);
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(false, "Fetch data successfully", response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(true, e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/userByPhone/{phone}")
    public ResponseEntity<ApiResultModel> findUserByPhoneNo(@PathVariable String phone) {
        try{
            UserGetOutputModel response = service.getUserByPhone(phone);
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(false, "Fetch data successfully", response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(true, e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/uservisit/{userId}")
    public ResponseEntity<ApiResultModel> findUserVisitByUserId(@PathVariable int userId) {
        try{
            ResponseModel response = service.getUserVisitByUserId(userId);
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(false, response.getMsg(), response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(true, e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/userByEmail/{email}")
    public ResponseEntity<ApiResultModel> findUserByEmail(@PathVariable String email) {
        try{
            UserGetOutputModel response = service.getUserByEmail(email);
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(false, "Fetch data successfully", response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(true, e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResultModel> updateUser(@RequestBody UserUpdateInputModel User) {
        try{
            ResponseModel response = service.updateUser(User);
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(false, response.getMsg(), response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(true, e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
    
}
