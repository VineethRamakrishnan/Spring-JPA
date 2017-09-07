/**
 * 
 */
package com.vikas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.entity.Faculty;

/**
 * @author vikas.sivaravindran
 *
 */
public interface FacultyRepository extends JpaRepository<Faculty,Integer> {

	Faculty save(Faculty faculty);
	List<Faculty> findAll();
}
