package de.oszimt.fian.hase.model.customer;

import de.oszimt.fian.hase.model.Address;
import de.oszimt.fian.hase.model.base.Person;

import java.time.LocalDate;

public class Customer extends Person {
	private LocalDate birthday;
	private Address address;
	
	public Customer(int id, String firstname, String lastname, LocalDate birthday, String email,
			Address address) {
		super(id, firstname, lastname, email);
		this.birthday = birthday;
		this.address = address;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + super.getId() + ", firstname=" + super.getFirstname() + ", lastname=" + super.getLastname()
				+ ", birthday=" + birthday + ", email=" + super.getEmail() + ", address=" + address + "]";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


}
