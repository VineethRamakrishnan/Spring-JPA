/**
 * 
 */
package com.vikas.entity;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author vikas.sivaravindran
 *
 */
@Entity
@Table(name="DEPARTMENT")
@Proxy(lazy=false)
@JsonIgnoreProperties(ignoreUnknown=true)
public class  Department{

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="DEP_NAME")
	private String dep_name;
	
	@Id
	@GeneratedValue
	@Column(name="DEP_ID")
	private int departmentId;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="department")
	@JsonManagedReference("STUDENT")
	@JsonIgnoreProperties("student")
	private Set<Student> student = new HashSet<>();
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="department")
	@JsonManagedReference("FACULTY")
	@JsonIgnoreProperties("faculty")
	private Set<Faculty> faculty = new HashSet<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COLLEGE_CODE")
	@JsonBackReference("DEPARTMENT")
	private College college;
	
	private int collegeId;
	
	
	public College getCollege() {
		return college;
	}


	public void setCollege(College college) {
		this.college = college;
	}


	public int getCollegeId() {
		return collegeId;
	}


	public void setCollegeId(int collegeCode) {
		this.collegeId = collegeCode;
	}




	public String getDep_name() {
		return dep_name;
	}


	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		departmentId = departmentId;
	}


	public Set<Student> getStudent() {
		return student;
	}


	public void setStudent(Set<Student> student) {
		this.student = student;
	}


	public Set<Faculty> getFaculty() {
		return faculty;
	}


	public void setFaculty(Set<Faculty> faculty) {
		this.faculty = faculty;
	}


	public Department(String dep_name, int departmentId, Set<Student> student, Set<Faculty> faculty, College college,
			int collegeCode) {
		super();
		this.dep_name = dep_name;
		departmentId = departmentId;
		this.student = student;
		this.faculty = faculty;
		this.college = college;
		this.collegeId = collegeCode;
	}



	

}
