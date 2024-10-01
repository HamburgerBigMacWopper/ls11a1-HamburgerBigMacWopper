package de.oszimt.fian.hase.model.employee;

import de.oszimt.fian.hase.model.base.Person;

public class Employee extends Person {
	private String telephone;
	
	public Employee(int id, String firstname, String lastname, String email, String telephone) {
		super(id, firstname, lastname, email);
		this.telephone = telephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Employee tempPerson) {
			return this.id == tempPerson.getId();
		}
		return false;
	}

	public String toString() {
		String returnstring = "";
		returnstring += "firstname: " + super.getFirstname();
		returnstring += "\tlastname: " + super.getLastname();
		returnstring += "\tid: " + super.getId();
		returnstring += "\temail: " + super.getEmail();
		returnstring += "\ttelephone: " + telephone;
		return returnstring;
	}
}
