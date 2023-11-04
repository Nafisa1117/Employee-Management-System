package com.aulacube.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulacube.exception.EmployeeNotFoundException;
import com.aulacube.model.Employee;
import com.aulacube.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	public Employee createEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	public Employee getEmployeeById(Long employeeId) {
		return empRepo.findById(employeeId)
				.orElseThrow(()-> new EmployeeNotFoundException(employeeId));
	}
	
	public List<Employee> getAllEmployees(){
		return empRepo.findAll();
	}
	
	public Employee updateEmployee(Long employeeId, Employee updatedEmp) {
		Employee existingEmployee = empRepo.findById(employeeId)
				.orElseThrow(()-> new EmployeeNotFoundException(employeeId));
	
		existingEmployee.setFirstName(updatedEmp.getFirstName());
		existingEmployee.setLastName(updatedEmp.getLastName());
		existingEmployee.setEmail(updatedEmp.getEmail());
		existingEmployee.setDepartment(updatedEmp.getDepartment());
		
		return empRepo.save(existingEmployee);
	}
	
	public void deleteEmployee(Long employeeId) {
		empRepo.deleteById(employeeId);
	}
}
