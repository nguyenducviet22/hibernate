package model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
	@Id
	@GeneratedValue
	@Column(name = "person_id")
	private long id;
	private String name;
	private Date birthDate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "spouse_id")
	private Person spouse;

	public Person() {
	}

	public Person(String name, Date birthDate, Person spouse) {
		this.name = name;
		this.birthDate = birthDate;
		this.spouse = spouse;
	}

	public Person(long id, String name, Date birthDate, Person spouse) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.spouse = spouse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Person getSpouse() {
		return spouse;
	}

	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", spouse=" + spouse + "]";
	}

}
