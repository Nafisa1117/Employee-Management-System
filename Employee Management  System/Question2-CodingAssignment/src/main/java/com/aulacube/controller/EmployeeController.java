package com.aulacube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulacube.model.Employee;
import com.aulacube.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
	//create new employee
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return empService.createEmployee(employee);
	}
	
	//Get employee
	@GetMapping("/{employeeId}")
	public Employee getEmployee(@PathVariable Long employeeId) {
		return empService.getEmployeeById(employeeId);
	}

}
