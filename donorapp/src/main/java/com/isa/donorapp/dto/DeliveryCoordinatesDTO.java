package com.isa.donorapp.dto;

public class DeliveryCoordinatesDTO {
	private double startLat;
	private double startLong;
	private double endLat;
	private double endLong;
	
	public DeliveryCoordinatesDTO() {}

	public DeliveryCoordinatesDTO(double startLat, double startLong, double endLat, double endLong) {
		this.startLat = startLat;
		this.startLong = startLong;
		this.endLat = endLat;
		this.endLong = endLong;
	}

	public double getStartLat() {
		return startLat;
	}

	public void setStartLat(double startLat) {
		this.startLat = startLat;
	}

	public double getStartLong() {
		return startLong;
	}

	public void setStartLong(double startLong) {
		this.startLong = startLong;
	}

	public double getEndLat() {
		return endLat;
	}

	public void setEndLat(double endLat) {
		this.endLat = endLat;
	}

	public double getEndLong() {
		return endLong;
	}

	public void setEndLong(double endLong) {
		this.endLong = endLong;
	}
}
