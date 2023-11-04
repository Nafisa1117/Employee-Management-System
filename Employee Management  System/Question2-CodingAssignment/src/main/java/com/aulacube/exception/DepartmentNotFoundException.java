package com.aulacube.exception;

public class DepartmentNotFoundException extends RuntimeException{

	public DepartmentNotFoundException(String departmentId) {
		super("department with ID "+ departmentId+ " not found");
	}
}
