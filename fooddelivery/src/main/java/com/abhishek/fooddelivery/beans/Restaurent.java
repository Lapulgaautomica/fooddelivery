package com.abhishek.fooddelivery.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Restaurent  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurantId;
	private String restaurantName;
	private String restaurantLocation;
	private int restaurantRating;
	
	@OneToMany(targetEntity =Food.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurent_id")
	private List<Food> food;
	

	public List<Food> getFood() {
		return food;
	}
	public void setFood(List<Food> food) {
		this.food = food;
	}
	public Restaurent() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Restaurent [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantLocation=" + restaurantLocation + ", restaurantRating=" + restaurantRating + "]";
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantLocation() {
		return restaurantLocation;
	}
	public void setRestaurantLocation(String restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}
	public float getRestaurantRating() {
		return restaurantRating;
	}
	public void setRestaurantRating(int restaurantRating) {
		this.restaurantRating = restaurantRating;
	}
	

}
