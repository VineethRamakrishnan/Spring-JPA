package com.vikas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{
	
	 Department save(Department department);
	 Department findByDepartmentId(int DepartmentId);
	 List<Department> findAll();


}
