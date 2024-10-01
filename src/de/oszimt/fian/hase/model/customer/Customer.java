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
	public boolean equals(Object o) {
		if (o instanceof Person tempPerson) {
			return this.id == tempPerson.getId();
		}
		return false;
	}

	@Override
	public String toString() {
		String returnstring = "";
		returnstring += "Customer [customerID=: " + super.getId();
		returnstring += ", firstname=" + super.getFirstname();
		returnstring += ", lastname= " + super.getLastname();
		returnstring += ", birthday=" + birthday;
		returnstring += ", email=" + super.getEmail();
		returnstring += ", address=" + address;
		returnstring += "]";
		return returnstring;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


}
