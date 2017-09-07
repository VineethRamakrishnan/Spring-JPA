/**
 * 
 */
package com.vikas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.entity.Faculty;
import com.vikas.repository.DepartmentRepository;
import com.vikas.repository.FacultyRepository;

/**
 * @author vikas.sivaravindran
 *
 */
@Service
public class FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;
	/**
	 * 
	 */
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public FacultyService() {
		// TODO Auto-generated constructor stub
	}

	public Faculty savefaculty(Faculty faculty) {
		// TODO Auto-generated method stub
		faculty.setDepartment(departmentRepository.findByDepartmentId(faculty.getDep_code()));
		return facultyRepository.save(faculty);
	}

	public List<Faculty> getFaculties() {
		
		// TODO Auto-generated method stub
		return facultyRepository.findAll();
	}

}
