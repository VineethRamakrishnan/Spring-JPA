/**

 * 
 */
package com.vikas.entity;

import java.io.Serializable;
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author vikas.sivaravindran
 *
 */
@Entity
@Table(name="STUDENT")
@Proxy(lazy=false)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Student implements Serializable{
	
	private static final long serialVersionUID = 12345678L;

	@Id
	@GeneratedValue
	@Column(name="STUDENT_NUMBER")
	private int rollnumber;
	
	@Column(name="STUDENT_NAME")
	private String name;
	
	private int departmentCode;

	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(int departmentCode) {
		this.departmentCode = departmentCode;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEP_ID")
	@JsonBackReference("STUDENT")
	private Department department;

	public int getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


	public static long getUid() {
		return serialVersionUID;
	}

public Student(int rollnumber, String name, int departmentCode, int collegeCode, Department department,College college) {
	super();
	this.rollnumber = rollnumber;
	this.name = name;
	this.departmentCode = departmentCode;
	this.department = department;
}

@Override
public String toString() {
	return "Student [rollnumber=" + rollnumber + ", name=" + name + ", departmentCode=" + departmentCode
			+ ", department=" + department + "]";
}



	

}
