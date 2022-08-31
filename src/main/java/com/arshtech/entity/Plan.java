package com.arshtech.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "PLAN_MASTER")
public class Plan {
	
	@Id
	@GeneratedValue
	@Column(name = "PLAN_ID")
	private Integer planId;
	
	@Column(name = "PLAN_NAME")
	private String planName;
	
	@Column(name = "PLAN_START_DATE")
	private LocalDate planStartDate;
	
	@Column(name = "PLAN_END_DATE")
	private LocalDate planEndDate;
	
	@Column(name = "ACTIVE_SWITCH")
	private String activeSw;
	
	@Column(name = "PLAN_CATEGORY_ID")
	private Integer planCategoryId;
	
	@Column(name="CREATE_DATE")
	private LocalDate createDate;	
	
	@Column(name="UPDATE_DATE")
	private LocalDate updateDate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	
}
