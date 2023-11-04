package com.aulacube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//Get all employees
	@GetMapping
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}

	//Update Employee
	@PutMapping("/{employeeId}")
	public Employee updateEmployee(@PathVariable Long employeeId, @RequestBody Employee updatedEmployee) {
		return empService.updateEmployee(employeeId, updatedEmployee);
	}
	
	//Delete Employee
	@DeleteMapping("/{employeeId}")
	public void deleteEmployee(@PathVariable Long employeeId) {
		empService.deleteEmployee(employeeId);
	}
}
