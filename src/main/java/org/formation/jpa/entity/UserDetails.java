package org.formation.jpa.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String username;
	@OneToMany(mappedBy="userDetails", fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST})
	private Collection<Vehicle> vehicles = new ArrayList<>();
	
	public UserDetails(int userId, String username, Collection<Vehicle> vehicles) {
		super();
		this.userId = userId;
		this.username = username;
		this.vehicles = vehicles;
	}

	public UserDetails(String username) {
		super();
		this.username = username;
	}
	
	public UserDetails() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
		vehicle.setUserDetails(this);
	}
	
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", username=" + username + "]";
	}

}
