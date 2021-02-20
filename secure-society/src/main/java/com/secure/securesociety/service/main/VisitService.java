package com.secure.securesociety.service.main;

import com.secure.securesociety.framework.model.ResponseModel;
import com.secure.securesociety.model.entity.User;
import com.secure.securesociety.model.entity.Visit;
import com.secure.securesociety.model.main.inputModel.VisitSaveInputModel;
import com.secure.securesociety.model.main.outputModel.UserGetOutputModel;
import com.secure.securesociety.model.main.outputModel.VisitGetOutputModel;
import com.secure.securesociety.repo.UserRepo;
import com.secure.securesociety.repo.VisitRepo;
import com.secure.securesociety.service.main.impl.IUserService;
import com.secure.securesociety.service.main.impl.IVisitService;
import com.secure.securesociety.utils.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class VisitService implements IVisitService {

    @Autowired
    private VisitRepo repository;

    @Autowired
    private UserRepo userRepo;

    public ResponseModel saveVisit(VisitSaveInputModel input) {
        User user = userRepo.findById(input.getUserId()).orElse(null);
        if (user != null) {
            if (!user.isAllowPass())
                return new ResponseModel(null, "User not allowed in society");
            String requiredStatus = "Entering";
            if (requiredStatus.equalsIgnoreCase(user.getStatus()))
                return new ResponseModel(null, "User already inside society");

            input.setEnterTime(DateUtility.getTime());
            Visit visit = repository.save(VisitSaveInputModel.mapVisit(input));
            user.setStatus("Entering");
            user.setLatestVisit(visit.getId());
            user.setUpdatedAt(DateUtility.getTime());
            userRepo.save(user);
            return new ResponseModel(null, "Visit saved successfully");
        }
        return new ResponseModel(null, "User does not exist");
    }

    public List<VisitGetOutputModel> getVisits() {
        List<VisitGetOutputModel> visitGetOutputModelList = new ArrayList<>();
        repository.findAll().forEach(obj -> {
            visitGetOutputModelList.add(VisitGetOutputModel.mapUser(obj));
        });
        return visitGetOutputModelList;
    }

    public VisitGetOutputModel getVisitById(int id) {
        return VisitGetOutputModel.mapUser(repository.findById(id).orElse(null));
    }

    public List<UserGetOutputModel> getUserIdsByDate(String date) {
        List<Integer> userIds = repository.findUserIdsByMatchMonthAndMatchDay(date);
        List<UserGetOutputModel> outputModels =  new ArrayList<>();
        userRepo.findByIdIn(userIds).forEach(obj -> {
            outputModels.add(UserGetOutputModel.mapUser(obj));
        });
        return outputModels;
    }


    public List<VisitGetOutputModel> getVisitByUserId(int id) {
        List<VisitGetOutputModel> visitGetOutputModelList = new ArrayList<>();
        repository.findByUserId(id).forEach(obj -> {
            visitGetOutputModelList.add(VisitGetOutputModel.mapUser(obj));
        });
        return visitGetOutputModelList;
    }

    public ResponseModel endVisit(int userId) {
        User user = userRepo.findById(userId).orElse(null);
        if (user == null)
            return new ResponseModel("User does not exist");
        if (!user.isAllowPass())
            return new ResponseModel("User not allowed in society");
        String requiredStatus = "Entering";
        if (!requiredStatus.equalsIgnoreCase(user.getStatus()))
            return new ResponseModel("User is no more inside the society");

        user.setStatus("Leaving");
        user.setUpdatedAt(DateUtility.getTime());
        Visit existingVisit = repository.findById(user.getLatestVisit()).orElse(null);
        existingVisit.setExitTime(Calendar.getInstance().getTime());
        repository.save(existingVisit);
        userRepo.save(user);
        return new ResponseModel("Visit ended successfully");
    }
}
