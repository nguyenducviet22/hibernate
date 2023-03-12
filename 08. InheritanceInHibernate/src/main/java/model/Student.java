package model;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Student extends Human {

	private double gpa;

	public Student() {
		super();
	}

	public Student(String id, String name, Date birthDate, double gpa) {
		super(id, name, birthDate);
		this.gpa = gpa;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
}
