package com.vikas.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.entity.Department;
import com.vikas.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	public DepartmentController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/department" , method=RequestMethod.POST , produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Department insertDepartments(@RequestBody Department department){
		
		Department placeDepartment = null;
		if(department != null){
			if(LOGGER.isInfoEnabled()){
				LOGGER.info("The Department is :{}",department);
			}
			
			placeDepartment = departmentService.place(department);
		}else{
			placeDepartment = null;
		}
		
		return placeDepartment;
	}
	
	@RequestMapping(value="/department" , method=RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Department> getAllDepartments(){
		
		List<Department> departmentList = departmentService.getAll();
		return departmentList;
	}
	
}
