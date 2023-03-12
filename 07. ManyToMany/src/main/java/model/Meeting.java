package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Meeting {

	@Id
	@GeneratedValue
	private int id;
	private String meetingName;
	private String address;
	private Date time;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "meeting_staff", 
	joinColumns = { @JoinColumn(name = "meeting_id") }, 
	inverseJoinColumns = {@JoinColumn(name = "staff_id") })

	private Set<Staff> staffList = new HashSet<Staff>();

	public Meeting() {
	}

	public Meeting(int id, String meetingName, String address, Date time) {
		this.id = id;
		this.meetingName = meetingName;
		this.address = address;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	public void addStaff (Staff s) {
		this.staffList.add(s);
	}

}
