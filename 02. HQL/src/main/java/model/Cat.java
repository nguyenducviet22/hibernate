package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cat {
	private Integer id;
	private String name;
	private Date birthDate;
	private Boolean sex;

	public Cat() {
	}

	public Cat(Integer id, String name, Date birthDate, Boolean sex) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.sex = sex;
	}

	public Cat(Integer id) {
		this.id = id;
	}

	@Id // main key
	@GeneratedValue // auto increment
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", sex=" + sex + "]";
	}

	

}
