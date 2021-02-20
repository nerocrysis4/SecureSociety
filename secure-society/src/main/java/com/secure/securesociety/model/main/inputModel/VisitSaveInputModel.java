package com.secure.securesociety.model.main.inputModel;

import com.secure.securesociety.model.entity.User;
import com.secure.securesociety.model.entity.Visit;
import com.secure.securesociety.model.main.outputModel.UserGetOutputModel;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class VisitSaveInputModel {

    private int userId;
    private Date enterTime;
    private String visitingReason;
    private String visitingFlat;
    private String vehicle;
    private int visitersCount;

    public static Visit mapVisit(VisitSaveInputModel inputModel){
        if(inputModel == null)
            return null;
        Visit visit = new Visit();
        visit.setUserId(inputModel.getUserId());
        visit.setEnterTime(inputModel.getEnterTime());
        visit.setVisitingReason(inputModel.getVisitingReason());
        visit.setVisitingFlat(inputModel.getVisitingFlat());
        visit.setVehicle(inputModel.getVehicle());
        visit.setVisitersCount(inputModel.getVisitersCount());

        return visit;
    }
}
