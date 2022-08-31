package com.arshtech.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arshtech.entity.Plan;
import com.arshtech.prop.AppProperties;
import com.arshtech.service.IPlanService;
import com.arshtech.service.PlanService;



@RestController
public class PlansController {
	
	@Autowired
	private IPlanService planService;
	@Autowired
	private AppProperties appProperties;
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories(){
		
		Map<Integer, String> categories=planService.getPlanCtegories();
		return new ResponseEntity<>(categories,HttpStatus.OK);
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		 
		String responseMsg="";
		boolean isSaved= planService.savePlan(plan);
		Map<String, String> messages=appProperties.getMessages();
		if(isSaved) {
			responseMsg=messages.get("palnSaveSucces");
		}else {
			responseMsg=messages.get("planSaveFail");
		}
		return new ResponseEntity<>(responseMsg, HttpStatus.CREATED);
	}
	@GetMapping("/allplans")
	public ResponseEntity<List<Plan>> allPlans(){
		
		 List<Plan> allPlans= planService.getAllPlans();
		return new ResponseEntity<>(allPlans,HttpStatus.OK);
	}
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId) {
		Plan plan=planService.getPlanById(planId);
		return new ResponseEntity<>(plan, HttpStatus.OK);
	}
	
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		
		String responseMsg="";
		Map<String, String> messages=appProperties.getMessages();
		boolean isUpdated=planService.updatePlan(plan);
		if(isUpdated) {
			responseMsg=messages.get("planUpadteSuccess");
		}else {
			responseMsg=messages.get("planUpdateFail");
		}
		return new ResponseEntity<>(responseMsg,HttpStatus.OK);
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		
		String responseMsg="";
		Map<String , String> messages=appProperties.getMessages();
		boolean isDeleted=planService.deletePlanById(planId);
		if(isDeleted) {
			responseMsg=messages.get("planDeleteSuccess");
		}else {
			responseMsg=messages.get("planDeleteFail");
		}
		return new ResponseEntity<>(responseMsg,HttpStatus.OK);
	}
	@PutMapping("status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId,@PathVariable String status){
		
		Map<String, String> messages=appProperties.getMessages();
		String responseMsg="";
		boolean isStatusChanged=planService.planStatusChange(planId, status);
		if(isStatusChanged) {
			responseMsg=messages.get("planStatusChange");
		}else {
			responseMsg=messages.get("planStatusChangeFail");
		}
		return new ResponseEntity<>(responseMsg,HttpStatus.OK);
	}
	
}
