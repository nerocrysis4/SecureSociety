package com.secure.securesociety.repo;

import com.secure.securesociety.model.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepo extends JpaRepository<Visit,Integer> {
    List<Visit> findByUserId(int userId);

    @Query(value = "SELECT DISTINCT user_id FROM visit WHERE enter_time Like %?1%", nativeQuery = true)
    List<Integer> findUserIdsByMatchMonthAndMatchDay(String enterDate);
}

