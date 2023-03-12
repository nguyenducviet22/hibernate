package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Staff {
	
	@Id
	private String id;
	private String fullName;
	private Date birthDate;
	@ManyToMany(mappedBy = "staffList")
	private Set<Meeting> meetingList = new HashSet<Meeting>();
	
	public Staff() {
	}

	public Staff(String id, String fullName, Date birthDate) {
		this.id = id;
		this.fullName = fullName;
		this.birthDate = birthDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
