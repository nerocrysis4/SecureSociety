package com.secure.securesociety.model.main.outputModel;

import com.secure.securesociety.model.entity.User;
import com.secure.securesociety.model.entity.Visit;
import lombok.Data;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class VisitGetOutputModel {

    private int id;
    private int userId;
    private Date enterTime;
    private Date exitTime;
    private String visitingReason;
    private String visitingFlat;
    private String vehicle;
    private int visitersCount;

    public static VisitGetOutputModel mapUser(Visit visit){
        if(visit == null)
            return null;
        VisitGetOutputModel visitGetOutputModel = new VisitGetOutputModel();
        visitGetOutputModel.setId(visit.getId());
        visitGetOutputModel.setUserId(visit.getUserId());
        visitGetOutputModel.setEnterTime(visit.getEnterTime());
        visitGetOutputModel.setExitTime(visit.getExitTime());
        visitGetOutputModel.setVisitingReason(visit.getVisitingReason());
        visitGetOutputModel.setVisitingFlat(visit.getVisitingFlat());
        visitGetOutputModel.setVehicle(visit.getVehicle());
        visitGetOutputModel.setVisitersCount(visit.getVisitersCount());

        return visitGetOutputModel;
    }
}
