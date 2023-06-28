package com.abhishek.fooddelivery.beans;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class OrderDTO implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String userEmail;
	private String ProductName;
	private int productQuantity;
	private String restaurentName;
	private int foodPrice;
	public OrderDTO() {
		super();
		
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userEmail=" + userEmail + ", ProductName=" + ProductName + ", qty="
				+ productQuantity + ", restaurentName=" + restaurentName + ", foodPrice=" + foodPrice + ", Address=" + Address
				+ "]";
	}
	private String Address;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getQty() {
		return productQuantity;
	}
	public void setQty(int qty) {
		this.productQuantity = qty;
	}
	public String getRestaurentName() {
		return restaurentName;
	}
	public void setRestaurentName(String restaurentName) {
		this.restaurentName = restaurentName;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
}
