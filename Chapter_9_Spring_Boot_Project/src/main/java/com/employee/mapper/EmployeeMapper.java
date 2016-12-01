package com.employee.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.employee.pojo.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmployeeId(rs.getInt("employee_id"));
		employee.setEmployeeName(rs.getString("employee_name"));
		employee.setEmployeeDepartment(rs.getString(3));
		employee.setEmployeeCity(rs.getString(4));
		employee.setEmployeeAllocation(rs.getString(6));
		employee.setDepartmentId(rs.getInt(7));
		return employee;
	}

}
