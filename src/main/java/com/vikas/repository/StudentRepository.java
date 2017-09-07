/**
 * 
 */
package com.vikas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vikas.entity.Student;

/**
 * @author vikas.sivaravindran
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

	Student save(Student student);
	
	List<Student> findAll();
	
}
