package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {

	@Id
	private String authorId;
	private String fullName;
	private Date birthDate;
	
	
	public Author() {
	}

	public Author(String authorId, String fullName, Date birthDate) {
		this.authorId = authorId;
		this.fullName = fullName;
		this.birthDate = birthDate;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
