package br.com.ufc.si.Entity;


public class User {
	
	private Long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String password;
	private int number;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private Long role;
	
	public User(String firstName, String lastName, String email, String gender,
			String password, int number, String street, String city, String state, String zipCode, String country,
			Long role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.number = number;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.role = role;
	}

	public User() {}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "userId = " + userId + ", firstName = " + firstName + ", lastName = " + lastName + ", email = " + email
				+ ", gender = " + gender + ", password = " + password + ", number = " + number
				+ ", street = " + street + ", city = " + city + ", state = " + state + ", zipCode = " + zipCode + ", country = "
				+ country + ", role = " + role + "]" + "\n";
	}
}
