package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Order {
	@Id
	@GeneratedValue
	private int id;
	private String customerName;
	private Date boughtDate;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<DetailedOrder> detailedList = new ArrayList<DetailedOrder>();

	public Order() {
	}

	public Order(int id, String customerName, Date boughtDate, List<DetailedOrder> detailedList) {
		this.id = id;
		this.customerName = customerName;
		this.boughtDate = boughtDate;
		this.detailedList = detailedList;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getBoughtDate() {
		return boughtDate;
	}

	public void setBoughtDate(Date boughtDate) {
		this.boughtDate = boughtDate;
	}

	public List<DetailedOrder> getDetailedList() {
		return detailedList;
	}

	public void setDetailedList(List<DetailedOrder> detailedList) {
		this.detailedList = detailedList;
	}

	public void addDeOrder(DetailedOrder deOrder) {
		this.detailedList.add(deOrder);
	}

}
