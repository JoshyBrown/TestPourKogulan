package org.formation.jpa.entity;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle {
	
	private String steeringWheel;

	public FourWheeler(int vehicleId, String vehicleName, String steeringWheel) {
		super();
		this.steeringWheel = steeringWheel;
	}

	public FourWheeler(String steeringWheel) {
		super();
		this.steeringWheel = steeringWheel;
	}

	public FourWheeler() {
		super();
	}

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
}
