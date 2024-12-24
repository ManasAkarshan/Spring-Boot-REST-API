package com.manas.SpringBootRestAPI.repository;

import com.manas.SpringBootRestAPI.entity.EmployeeEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query("SELECT e FROM EmployeeEntity e WHERE e.isActive = :active")
    List<EmployeeEntity> findByIsActive(@Param("active") Boolean active);
}
