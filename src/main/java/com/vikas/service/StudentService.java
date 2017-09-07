/**
 * 
 */
package com.vikas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.entity.College;
import com.vikas.entity.Student;
import com.vikas.repository.DepartmentRepository;
import com.vikas.repository.StudentRepository;

/**
 * @author vikas.sivaravindran
 *
 */
@Service
public class StudentService {

	/**
	 * 
	 */
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	public StudentService() {
		// TODO Auto-generated constructor stub
	}


	public Student placeStudent(Student student) {
		// TODO Auto-generated method stub
		student.setDepartment(departmentRepository.findByDepartmentId(student.getDepartmentCode()));
		return studentRepository.save(student);
	}


	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}


}
