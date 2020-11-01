package com.ecom.ecom.repository;

import com.ecom.ecom.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<UserDetail, Long> {
    UserDetail aunthenticateUser(String name, String password);
    UserDetail findByUserId(Long userId);
}
