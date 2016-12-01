package com.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.pojo.Employee;
import com.employee.pojo.ResponseDetail;
import com.employee.service.EmployeeService;

@Controller
@RestController
public class EmployeeController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	private static final Integer ERORR_CODE = 1;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ResponseEntity<ResponseDetail> addEmployee(@RequestBody Employee employee) throws Exception {
		LOG.info("In addEmployee()");
		ResponseDetail response = new ResponseDetail();
		employee = employeeService.addEmployee(employee);
		response.setErrorCode(ERORR_CODE);
		response.setMessage("Employee ID " + employee.getEmployeeId() + " added");
		return new ResponseEntity<ResponseDetail>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/getParticularEmployee/{employeeId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) throws Exception {
		LOG.info("In getEmployee()");
		Employee employee= employeeService.getEmployee(employeeId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);	
	}

	@RequestMapping(value = "/getEmployeeList", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Employee> getEmployeeList() throws Exception {
		LOG.info("In getEmployeeList()");
		Employee employee = new Employee();
		List<Employee> employeesList = employeeService.getEmployeeList();
		employee.setEmployeeList(employeesList);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);	
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ResponseEntity<ResponseDetail> updateEmployee(@RequestBody Employee employee) throws Exception {
		LOG.info("In updateEmployee()");
		ResponseDetail response = new ResponseDetail();
		int record = employeeService.updateEmployee(employee);
		response.setErrorCode(record);
		response.setMessage("Employee ID " + employee.getEmployeeId() + " updated");
		return new ResponseEntity<ResponseDetail>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.POST)
	public ResponseEntity<ResponseDetail> deleteEmployee(@PathVariable int employeeId) throws Exception {
		LOG.info("In deleteEmployee()");
		ResponseDetail response = new ResponseDetail();
		int record = employeeService.deleteEmployee(employeeId);
		response.setErrorCode(record);
		response.setMessage("Employee ID " + employeeId + " deleted");
		return new ResponseEntity<ResponseDetail>(response, HttpStatus.OK);
	}

}
