package com.employee.dao;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.employee.mapper.EmployeeMapper;
import com.employee.pojo.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Employee addEmployee(Employee employee) throws Exception {
		LOG.info("In dao add()");
		try {
			String query = "insert into employee values(?,?,?,?,?,?,?)";
			int record = jdbcTemplate.update(query, employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeDepartment(), employee.getEmployeeCity()
					, employee.getEmployeeDate(), employee.getEmployeeAllocation(), employee.getDepartmentId());
			LOG.info(record + " record inserted");
		} catch (Exception e) {
			LOG.error("Employee ID already exist: ", e);
			throw new SQLException("Employee ID already exist");
		}
		return employee;
	}

	@Override
	public Employee getEmployee(int employeeId) throws Exception {
		LOG.info("In dao get()");
		String query = "select * from employee where EMPLOYEE_ID = " + employeeId;
		Employee employee = jdbcTemplate.queryForObject(query, new EmployeeMapper());
		if(employee != null){
			return employee;
		} else {
			throw new EmptyResultDataAccessException("Employee ID does not exist", 0);
		}
	}


	@Override
	public List<Employee> getEmployeeList() throws Exception {
		LOG.info("In dao getEmployeeList()");
		String query = "select * from employee";
		List<Employee> employeesList = jdbcTemplate.query(query, new EmployeeMapper());
		if(employeesList.size() > 0){
			return employeesList;
		} else {
			throw new EmptyResultDataAccessException("No Records found", 0);
		}
	}

	@Override
	public int updateEmployee(Employee employee) throws Exception {
		LOG.info("In dao update()");
		int record;
		String query = "update employee set EMPLOYEE_DEPARTMENT = ?, EMPLOYEE_CITY = ?, EMPLOYEE_ALLOCATED = ? where EMPLOYEE_ID = ?";
		record = jdbcTemplate.update(query, employee.getEmployeeDepartment(), employee.getEmployeeCity(), employee.getEmployeeAllocation(), employee.getEmployeeId());
		return record;
	}

	@Override
	public int deleteEmployee(int employeeId) throws Exception {
		LOG.info("In dao delete()");
		int record;
		String query = "delete from employee where EMPLOYEE_ID = ?";
		record = jdbcTemplate.update(query, employeeId);
		return record;
	}

}
