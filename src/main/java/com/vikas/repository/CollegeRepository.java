/**
 * 
 */
package com.vikas.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vikas.entity.College;


/**
 * @author vikas.sivaravindran
 *
 */
public interface CollegeRepository extends JpaRepository<College,Integer>{


	 College save(College college);
	 College findByCollegeCode(int collegeCode);
	 List<College> findAll();

}
