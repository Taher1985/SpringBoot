package com.employee.pojo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown= true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Employee {
	
	@JsonProperty("Employee Id")
	private Integer employeeId;
	
	@JsonProperty("Employee Name")
	private String employeeName;
	
	@JsonProperty("Employee Department")
	private String employeeDepartment;
	
	@JsonProperty("Employee City")
	private String employeeCity;
	
	@JsonProperty("Employee Date")
	private Date employeeDate;
	
	@JsonProperty("Employee Date")
	private String employeeAllocation;
	
	@JsonProperty("Department Id")
	private Integer departmentId;
	
	@JsonProperty("Employee List")
	private List<Employee> employeeList;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	public Date getEmployeeDate() {
		return employeeDate;
	}

	public void setEmployeeDate(Date employeeDate) {
		this.employeeDate = employeeDate;
	}

	public String getEmployeeAllocation() {
		return employeeAllocation;
	}

	public void setEmployeeAllocation(String employeeAllocation) {
		this.employeeAllocation = employeeAllocation;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
}
