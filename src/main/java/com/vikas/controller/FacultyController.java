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

import com.vikas.entity.Faculty;
import com.vikas.service.FacultyService;

/**
 * @author vikas.sivaravindran
 *
 */
@RestController
@RequestMapping("/api")
public class FacultyController {

	
	 private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	 @Autowired
	private FacultyService facultyService;
	
	public FacultyController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/faculty" , method=RequestMethod.POST , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Faculty saveFaculty(@RequestBody Faculty faculty){
		Faculty facultysave = null;
		
		if(faculty != null){
			if(LOGGER.isInfoEnabled()){
				LOGGER.info("The faculty details are: {}",faculty);
			}
			facultysave = facultyService.savefaculty(faculty);
		}
		return facultysave;
		
	}
	@RequestMapping(value="/faculty" , method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Faculty> getFacultiesList(){
		
		return facultyService.getFaculties();
	}

}
