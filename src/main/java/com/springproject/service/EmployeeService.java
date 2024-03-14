package com.springproject.service;

import java.util.List;

import com.springproject.model.Department;
import com.springproject.model.Employee;

public interface EmployeeService {
	void addEmp(Employee emp);
	void deleteEmp (int id);
	void updateEmp(Employee emp);
	Employee getEmpById(int id);
	List<Employee> getAllEmp();

}
