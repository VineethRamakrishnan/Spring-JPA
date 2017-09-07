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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.entity.College;
import com.vikas.service.CollegeService;

/**
 * @author vikas.sivaravindran
 *
 */
@RestController
@RequestMapping("/api")
public class CollegeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CollegeController.class);
	
	@Autowired
	private CollegeService collegeService;

	
	@RequestMapping(value="/college" , method=RequestMethod.POST , produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody College insertCollege(@RequestBody College college){
		
		College collegesave = null;
		
		if(college != null){
			if(LOGGER.isInfoEnabled()){
				LOGGER.info("The College Details are:::"+college);
			}
		 collegesave = collegeService.saveCollege(college);
		}
		return collegesave;
	
	}
	
	@RequestMapping(value="/college" , method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<College> getColleges(){
		List<College> colleges = collegeService.getAll();
		return colleges;
	}
	
}
