/**
 * 
 */
package com.vikas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.vikas.entity.College;
import com.vikas.repository.CollegeRepository;

/**
 * @author vikas.sivaravindran
 *
 */
@Service
public class CollegeService {

	/**
	 * 
	 */
	@Autowired
	private CollegeRepository collegeRepository;
	
	public CollegeService() {
		// TODO Auto-generated constructor stub
	}

	public College saveCollege(College college) {
		// TODO Auto-generated method stub
		return collegeRepository.save(college);
	}

	public List<College> getAll() {
		// TODO Auto-generated method stub
		return collegeRepository.findAll();
	}

}
