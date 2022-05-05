package com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.dao;

import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select i from User i where i.username = :username")
    public User findByUsername(@Param("username") String un);
    @Modifying
    @Query(value ="delete from users d where d.username= :username", nativeQuery = true)
    @Transactional
    public void deleteById(@Param("username") String un);
}
