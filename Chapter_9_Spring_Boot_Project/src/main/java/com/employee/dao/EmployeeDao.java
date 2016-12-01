package com.employee.dao;

import java.util.List;

import com.employee.pojo.Employee;

public interface EmployeeDao {
	public Employee addEmployee(Employee employee) throws Exception;
	public Employee getEmployee(int employeeId) throws Exception;
	public List<Employee> getEmployeeList() throws Exception;
	public int updateEmployee(Employee employee) throws Exception;
	public int deleteEmployee(int employeeId) throws Exception;
}
