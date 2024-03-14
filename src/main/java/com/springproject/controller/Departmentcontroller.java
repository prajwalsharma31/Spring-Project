package com.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springproject.model.Department;
import com.springproject.service.DepartmentService;
import com.springproject.utils.DepartmentExcelView;
import com.springproject.utils.DepartmentPdfView;

@Controller
//@RequestMapping("/department")
public class Departmentcontroller {
	@Autowired
	private DepartmentService deptService;
	
	
	@GetMapping("/department")
	//@RequestMapping(value="/department", method=RequestMethod)
	public String getDepartment() {
		
		return "Department";
		
	}
	@PostMapping("/department")
	public String postDepartment( @ModelAttribute Department dept) {
		
		deptService.addDept(dept);
		return "Department";
	}
	
	@GetMapping("/departmentlist")
	public String DepartmentList(Model model) {
		
		model.addAttribute("dlist",deptService.getAllDepts());
		return "DepartmentListForm";
	}
	@GetMapping("/dept/delete")
	public String delete(@RequestParam int id) {
		deptService.deleteDept(id);
		return "redirect:/departmentlist";
	}
	
	@GetMapping("/dept/edit")
	public String edit(@RequestParam int id  , Model model) {
		model.addAttribute("dModel", deptService.getDeptById(id));
		return "DepartmentEditForm";
	}
	
	@PostMapping("/dept/update")
	public String update(@ModelAttribute Department dept) {
		deptService.updateDept(dept);
		
		return "redirect:/departmentlist";
		
	}
	@GetMapping("/dept/excel")
	public ModelAndView excel() {
		
		ModelAndView mv= new ModelAndView();
		mv.addObject("dlist", deptService.getAllDepts());
		mv.setView(new DepartmentExcelView());
		
		return mv;
	}
	@GetMapping("/dept/pdf")
	public ModelAndView pdf() {
		
		ModelAndView mv= new ModelAndView();
		mv.addObject("dlist", deptService.getAllDepts());
		mv.setView(new DepartmentPdfView());
		
		return mv;
	}
	
	
	

}
