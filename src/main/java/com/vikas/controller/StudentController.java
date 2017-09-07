/**
 * 
 */
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

import com.vikas.entity.Student;
import com.vikas.service.StudentService;

/**
 * @author vikas.sivaravindran
 *
 */
@RestController
@RequestMapping("/api")
public class StudentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CollegeController.class);
	/**
	 * 
	 */
	@Autowired
	private StudentService studentService;
	
	public StudentController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/student" , method=RequestMethod.POST , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Student insertStudent(@RequestBody Student student){
		
		Student Newstudent = null;
		
		if(student != null){
			if(LOGGER.isInfoEnabled()){
				LOGGER.info("The Student Details are : {}",student);
			}
			Newstudent = studentService.placeStudent(student);
		}
		return Newstudent;
 		
	}
	
	@RequestMapping(value="/student" , method=RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Student> getStudent(){
		
		return studentService.getAllStudents();
	}

}
