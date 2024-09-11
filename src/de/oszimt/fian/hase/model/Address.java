package de.oszimt.fian.hase.model;

public class Address {
	private String street;
	private String house;
	private String postalCode;
	private String city;
	
	public Address(String street, String house, 
			       String postalCode, String city) {
		super();
		this.street = street;
		this.house = house;
		this.postalCode = postalCode;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", house=" + house + ", postalCode=" + postalCode + ", city=" + city
				+ "]";
	}

}
