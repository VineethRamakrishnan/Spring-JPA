/**
 * 
 */
package com.vikas.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author vikas.sivaravindran
 *
 */
@Entity
@Table(name="COLLEGE")
@Proxy(lazy=false)
@JsonIgnoreProperties(ignoreUnknown=true)
public class College implements Serializable{
	
	private static final long serialVersionUID = 12345678L;
	
	public int getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(int collegeCode) {
		this.collegeCode = collegeCode;
	}

	@Id
	@GeneratedValue
	@Column(name="COLLEGE_CODE")
	private int collegeCode;
	
	@Column(name="COLLEGE_NAME")
	private String college_name;
	
	@Column(name="COLLEGE_ADDRESS")
	private String address;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="college")
	@JsonManagedReference("DEPARTMENT")
	private Set<Department> departments = new HashSet<>();
	
	

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	

	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "College [collegeCode=" + collegeCode + ", college_name=" + college_name + ", address=" + address
				+ ", departments=" + departments + "]";
	}

	public College(String college_name, String address, Set<Student> student, Set<Department> departments,int collegeCode) {
		super();
		this.college_name = college_name;
		this.address = address;
		this.departments = departments;
		this.collegeCode = collegeCode;
	}

}
