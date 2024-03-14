package com.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.model.Department;
import com.springproject.model.Employee;
import com.springproject.service.DepartmentService;
import com.springproject.service.EmployeeService;

@Controller
public class Employeecontroller {
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/employee")
	public String getEmployee(Model model) {
		
		model.addAttribute("dlist" ,deptService.getAllDepts());
		return "EmployeeForm";
	}
	@PostMapping("/employee")
	public String postEmployee(@ModelAttribute Employee emp) {
		
		empService.addEmp(emp);
		return "redirect:/employee";
	}
	@GetMapping("/employeelist")
	public String EmployeeList(Model model) {
		
		model.addAttribute("elist",empService.getAllEmp());
		return "EmployeeList";
	}
	@GetMapping("/emp/delete")
	public String delete(@RequestParam int id) {
		empService.deleteEmp(id);
		return "redirect:/employeelist";
	}
	
	@GetMapping("/emp/edit")
	public String edit(@RequestParam int id  , Model model) {
		model.addAttribute("eModel", empService.getEmpById(id));
		return "EmployeeEditForm";
	}
	
	@PostMapping("/emp/update")
	public String update(@ModelAttribute Employee emp) {
		empService.updateEmp(emp);
		
		return "redirect:/Employeelist";
		
	}
	
	

}
