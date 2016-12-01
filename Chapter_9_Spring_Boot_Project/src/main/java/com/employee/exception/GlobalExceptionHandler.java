package com.employee.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.pojo.ResponseDetail;
import com.employee.util.EmployeeUtil;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public @ResponseBody ResponseEntity<ResponseDetail> handleEmptyResultDataAccessException(EmptyResultDataAccessException exception, HttpServletRequest request) {
		ResponseDetail error = new ResponseDetail();
		HttpStatus status = EmployeeUtil.getStatus(request);
		error.setErrorCode(status.value());
		error.setMessage("No Records found");
		error.setExceptionDetail(exception.getMessage());
		return new ResponseEntity<ResponseDetail>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(SQLException.class)
	public @ResponseBody ResponseEntity<ResponseDetail> handleSQLException(SQLException exception, HttpServletRequest request) {
		ResponseDetail error = new ResponseDetail();
		HttpStatus status = EmployeeUtil.getStatus(request);
		error.setErrorCode(status.value());
		error.setMessage("Employee ID already exist");
		error.setExceptionDetail(exception.getMessage());
		return new ResponseEntity<ResponseDetail>(error, HttpStatus.OK);
	}

}
