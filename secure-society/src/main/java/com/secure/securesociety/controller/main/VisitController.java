package com.secure.securesociety.controller.main;

import com.secure.securesociety.framework.model.ApiResultModel;
import com.secure.securesociety.framework.model.ResponseModel;
import com.secure.securesociety.model.entity.Visit;
import com.secure.securesociety.model.main.inputModel.VisitSaveInputModel;
import com.secure.securesociety.model.main.outputModel.UserGetOutputModel;
import com.secure.securesociety.model.main.outputModel.VisitGetOutputModel;
import com.secure.securesociety.service.main.impl.IVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/secureSociety")
public class VisitController {

    @Autowired
    private IVisitService service;

    @PostMapping("/visit/start")
    public ResponseEntity<ApiResultModel> addVisit(@RequestBody VisitSaveInputModel inputModel) {
        try{
            ResponseModel response = service.saveVisit(inputModel);
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(false, response.getMsg(), response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(true, e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/visits")
    public ResponseEntity<ApiResultModel> findAllVisits() {
        try{
            List<VisitGetOutputModel> response = service.getVisits();
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(false, "Fetch data successfully", response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(true, e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


    @GetMapping("/visitById/{id}")
    public ResponseEntity<ApiResultModel>  findVisitById(@PathVariable int id) {
        try{
            VisitGetOutputModel response = service.getVisitById(id);
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(false, "Fetch visit successfully", response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(true, e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/visit/end/{userId}")
    public ResponseEntity<ApiResultModel> updateVisit(@PathVariable int userId) {

        try{
            ResponseModel response = service.endVisit(userId);
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(false, response.getMsg(), response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(true, e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


    @GetMapping("/uservisitByDate/{date}")
    public ResponseEntity<ApiResultModel> findUserVisitByUserId(@PathVariable String date) {
        try{
            List<UserGetOutputModel> response = service.getUserIdsByDate(date);
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(false, "", response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ApiResultModel>(new ApiResultModel(true, e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    
}
