package de.oszimt.fian.hase.model.customer;

import de.oszimt.fian.hase.model.Address;
import de.oszimt.fian.hase.model.base.Person;

import java.time.LocalDate;

public abstract class Customer extends Person {
	protected Address address;
	protected char status;
	protected char paymentType;
	
	public Customer(int id, String firstname, String lastname, String email,
			Address address) {
		super(id, firstname, lastname, email);
		this.address = address;
		this.status = 'G';
		this.paymentType = 'V';
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public char getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(char paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public abstract boolean equals(Object o);

	@Override
	public abstract String toString();

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public abstract String getAddressLabel();

	public abstract boolean isAutomaticOrderVolume(int orderVolume);

}
