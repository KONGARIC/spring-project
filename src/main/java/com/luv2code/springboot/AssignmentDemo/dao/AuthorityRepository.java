package com.luv2code.springboot.AssignmentDemo.dao;

import com.luv2code.springboot.AssignmentDemo.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
    @Query("select i from Authority i where i.username = :username")
    public Authority findByUsername(@Param("username") String un);
    @Modifying
    @Query(value ="delete from authorities d where d.username= :username", nativeQuery = true)
    @Transactional
    public void deleteByUsername(@Param("username") String un);
}
