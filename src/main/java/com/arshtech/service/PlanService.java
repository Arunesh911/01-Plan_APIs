package com.arshtech.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshtech.entity.Plan;
import com.arshtech.entity.PlanCategory;
import com.arshtech.repo.IPlanCategoryrepo;
import com.arshtech.repo.IPlanRepo;

@Service
public class PlanService  implements IPlanService{
	
	@Autowired
	private IPlanRepo planRepo;
	@Autowired
	private IPlanCategoryrepo planCategoryrepo;

	@Override
	public Map<Integer, String> getPlanCtegories() {

		List<PlanCategory> categories=planCategoryrepo.findAll();
		
		Map<Integer, String> categoryMap=new HashMap<>();
		
		categories.forEach(category -> {
			categoryMap.put(category.getCategoryId(), category.getCategoryName());
			
		});
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan saved=planRepo.save(plan);
		return  saved.getPlanId() != null;
	}

	@Override
	public List<Plan> getAllPlans() {
		return planRepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		 Optional<Plan> findById=planRepo.findById(planId);
		 if(findById.isPresent()) {
			 return findById.get();
		 }
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		Plan save= planRepo.save(plan);
		return save.getPlanId()!=null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		boolean status=false;
		try {
			planRepo.deleteById(planId);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public boolean softDelete(Integer planId, String activeSw) {

		return false;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		Optional<Plan> findById=planRepo.findById(planId);
		if(findById.isPresent()) {
			Plan plan=findById.get();
			plan.setActiveSw(status);
			planRepo.save(plan);
			return true;
		}
		return false;
	}

}
