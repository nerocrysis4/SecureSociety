package com.secure.securesociety.repo;

import com.secure.securesociety.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo  extends JpaRepository<User,Integer> {
    User findByFirstName(String name);
    User findByMobileNumber(String phoneNo);
    User findByEmail(String phoneNo);
    List<User> findByStatus(String status);
    boolean existsByMobileNumber(String mobileNumber);
    boolean existsByEmail(String email);
    List<User> findByIdIn(List<Integer> ids);

}

