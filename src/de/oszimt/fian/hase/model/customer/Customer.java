package de.oszimt.fian.hase.model.customer;

import de.oszimt.fian.hase.model.Address;

import java.time.LocalDate;

public class Customer {
	private LocalDate birthday;
	private String email;
	private Address address;

	protected int id;
	protected String firstname;
	protected String lastname;
	
	public Customer(int id, String firstname, String lastname, LocalDate birthday, String email,
			Address address) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.email = email;
		this.address = address;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", birthday=" + birthday + ", email=" + email + ", address=" + address + "]";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if ( o instanceof Customer) {
			Customer tempContract = (Customer) o;
			return this.id == tempContract.getId();
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
