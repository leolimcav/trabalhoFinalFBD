package br.com.ufc.si.Entity;

public class Place {
	
	private Long placeId;
	private String city;
	private String country;
	private String description;
	private Long ownerId;
	
	public Place(String city, String country, String description, Long ownerId) {
		this.city = city;
		this.country = country;
		this.description = description;
		this.ownerId = ownerId;
	}
	
	public Place() {}

	public Long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return "Place [placeId=" + placeId + ", city=" + city + ", country=" + country + ", description=" + description
				+ ", ownerId=" + ownerId + "]" + "\n";
	}
	
}
