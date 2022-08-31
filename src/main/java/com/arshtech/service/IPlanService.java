package com.arshtech.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import java.util.List;

import com.arshtech.entity.Plan;


public interface IPlanService {

	public Map<Integer, String> getPlanCtegories();
	
	public boolean savePlan(Plan plan);
	
	public List<Plan> getAllPlans();
	
	public Plan getPlanById(Integer planId);
	
	public boolean updatePlan(Plan plan);
	
	public boolean deletePlanById(Integer planId);
	
	public boolean softDelete(Integer planId, String activeSw);
	
	public boolean planStatusChange(Integer planId, String status);
	
}
