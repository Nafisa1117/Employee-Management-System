package com.aulacube.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulacube.exception.DepartmentNotFoundException;
import com.aulacube.model.Department;
import com.aulacube.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository deptRepo;
	
	public Department createDepartment(Department department) {
		return deptRepo.save(department);
	}
	
	public Department getDepartmentById(String departmentId) {
		
		return deptRepo.findById(departmentId)
				.orElseThrow(()-> new DepartmentNotFoundException(departmentId));
	}
	
	public List<Department> getAlldepartments(){
		return deptRepo.findAll();
	}
	
	public Department updateDepartment(String departmentId, Department updatedDepartment) {
		Department existingDepartment = deptRepo.findById(departmentId)
				.orElseThrow(()-> new DepartmentNotFoundException(departmentId));
	
		existingDepartment.setDepartmentName(updatedDepartment.getDepartmentName());
	
		return deptRepo.save(existingDepartment);
	}
	
	public void deleteDepartment(String departmentId) {
		deptRepo.deleteById(departmentId);
	}

}
