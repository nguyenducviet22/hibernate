package model;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Teacher extends Human {

	private String subject;

	public Teacher() {
	}

	public Teacher(String id, String name, Date birthDate, String subject) {
		super(id, name, birthDate);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
