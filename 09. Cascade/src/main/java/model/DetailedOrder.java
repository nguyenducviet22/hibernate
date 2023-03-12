package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetailedOrder {
	@Id
	@GeneratedValue
	private int id;
	private String productName;
	private double quantity;
	private double soldPrice;
	private double total;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public DetailedOrder() {
	}

	public DetailedOrder(int id, String productName, double quantity, double soldPrice, double total, Order order) {
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.soldPrice = soldPrice;
		this.total = total;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
