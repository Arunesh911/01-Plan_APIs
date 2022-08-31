package com.arshtech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arshtech.entity.PlanCategory;

@Repository
public interface IPlanCategoryrepo extends JpaRepository<PlanCategory, Integer>{

}
