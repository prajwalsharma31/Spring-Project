package com.springproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.model.Department;
import com.springproject.repository.DepartmentRepository;
import com.springproject.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository deptRepo;
	
	@Override
	public void addDept(Department dept) {
		// TODO Auto-generated method stub
		
		deptRepo.save(dept);
		
	}

	@Override
	public void deleteDept(int id) {
		// TODO Auto-generated method stub
		deptRepo.deleteById(id);
	}

	@Override
	public void updateDept(Department dept) {
		// TODO Auto-generated method stub
		deptRepo.save(dept);
		
	}

	@Override
	public Department getDeptById(int id) {
		// TODO Auto-generated method stub
		deptRepo.findById(id).get();
		return null;
	}

	@Override
	public List<Department> getAllDepts() {
		// TODO Auto-generated method stub
		
		
		return deptRepo.findAll();
	}

}
