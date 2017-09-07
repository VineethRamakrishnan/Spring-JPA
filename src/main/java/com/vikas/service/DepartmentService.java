/**
 * 
 */
package com.vikas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.entity.Department;
import com.vikas.repository.CollegeRepository;
import com.vikas.repository.DepartmentRepository;

/**
 * @author vikas.sivaravindran
 *
 */
@Service
public class DepartmentService {

	/**
	 * 
	 */
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private CollegeRepository collegeRepository;
	
	public DepartmentService() {
		// TODO Auto-generated constructor stub
	}

	public Department place(Department department) {
		// TODO Auto-generated method stub
		department.setCollege(collegeRepository.findByCollegeCode(department.getCollegeId()));
		return departmentRepository.save(department);
	}

	public List<Department> getAll() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

}
