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

import com.aulacube.model.Department;
import com.aulacube.model.Employee;
import com.aulacube.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;

	
    // Create a new Department
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return deptService.createDepartment(department);
    }

    // Get a specific Department by ID
    @GetMapping("/{departmentId}")
    public Department getDepartment(@PathVariable String departmentId) {
        return deptService.getDepartmentById(departmentId);
    }
    
    // Get All departments
    @GetMapping
    public List<Department> getAllDepartments(){
    	return deptService.getAlldepartments();
    }
    
    //Update Department
    @PutMapping("/{departmentId}")
    public Department updateDepartment(@PathVariable String departmentId,@RequestBody Department updatedDepartment ) {
    	return deptService.updateDepartment(departmentId, updatedDepartment);
    }
    
    //Delete Department
    @DeleteMapping("/{departmentId}")
    public void deleteDepartment(@PathVariable String departmentId) {
    	 deptService.deleteDepartment(departmentId);
    }
}
