package com.arshtech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arshtech.entity.Plan;

@Repository
public interface IPlanRepo extends JpaRepository<Plan, Integer>{

}
