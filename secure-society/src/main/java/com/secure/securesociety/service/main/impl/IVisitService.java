package com.secure.securesociety.service.main.impl;

import com.secure.securesociety.framework.model.ResponseModel;
import com.secure.securesociety.model.entity.Visit;
import com.secure.securesociety.model.main.inputModel.VisitSaveInputModel;
import com.secure.securesociety.model.main.outputModel.UserGetOutputModel;
import com.secure.securesociety.model.main.outputModel.VisitGetOutputModel;

import java.util.List;

public interface IVisitService {

    ResponseModel saveVisit(VisitSaveInputModel Visit);

    List<VisitGetOutputModel> getVisits();

    VisitGetOutputModel getVisitById(int id);

    List<UserGetOutputModel> getUserIdsByDate(String date);

    ResponseModel endVisit(int userId);
}
