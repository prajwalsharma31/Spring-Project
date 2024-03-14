package com.springproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.model.Employee;
import com.springproject.repository.EmployeeRepository;
import com.springproject.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public void addEmp(Employee emp) {
		// TODO Auto-generated method stub
		empRepo.save(emp);
		
	}

	@Override
	public void deleteEmp(int id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
		
	}

	@Override
	public void updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		empRepo.save(emp);
		
	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		
		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

}
