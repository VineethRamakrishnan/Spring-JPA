/**
 * 
 */
package com.vikas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author vikas.sivaravindran
 *
 */
@Entity
@Table(name="Faculty")
@Proxy(lazy=false)
public class Faculty{


	@Id
	@GeneratedValue
	@Column(name="FACULTY_ID")
	private int faculty_id;

	@Column(name="FACULTY_NAME",unique=true)
	private String faculty_name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEP_ID")
	@JsonBackReference("FACULTY")
	private Department department;
	
	private int dep_code;
	

	public int getDep_code() {
		return dep_code;
	}

	public void setDep_code(int dep_code) {
		this.dep_code = dep_code;
	}

	public int getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}

	public String getFaculty_name() {
		return faculty_name;
	}

	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	

}
