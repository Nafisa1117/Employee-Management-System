package com.aulacube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulacube.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, String>{

}
