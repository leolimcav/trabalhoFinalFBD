package br.com.ufc.si.Entity;


public class Trip {
	
	private Long tripId;
	private String departureDate;
	private String returnDate;
	private double price;
	private Long userId;
	private Long placeId;
	
	public Trip(String departureDate, String returnDate, double price, Long userId, Long placeId) {
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.price = price;
		this.userId = userId;
		this.placeId = placeId;
	}
	
	public Trip() {}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}

	@Override
	public String toString() {
		return "Trip [tripId=" + tripId + ", departureDate=" + departureDate + ", returnDate=" + returnDate + ", price="
				+ price + ", userId=" + userId + ", placeId=" + placeId + "]" + "\n";
	}
	
}
