package org.formation.jpa.entity;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {

	private String steeringWheel;

	public TwoWheeler(int vehicleId, String vehicleName, String steeringWheel) {
		super();
		this.steeringWheel = steeringWheel;
	}

	public TwoWheeler(String steeringWheel) {
		super();
		this.steeringWheel = steeringWheel;
	}

	public TwoWheeler() {
		super();
	}
	
	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
}
