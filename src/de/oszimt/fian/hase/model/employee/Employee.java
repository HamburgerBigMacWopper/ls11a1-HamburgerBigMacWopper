package de.oszimt.fian.hase.model.employee;

public class Employee {
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String telephone;
	
	public Employee(int id, String firstname, String lastname, String email, String telephone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
		this.email = email;
		this.telephone = telephone;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String toString() {
		String returnstring = "";
		returnstring += "firstname: " + firstname;
		returnstring += "\tlastname: " + lastname;
		returnstring += "\tid: " + id;
		returnstring += "\temail: " + email;
		returnstring += "\ttelephone: " + telephone;
		return returnstring;
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Employee employee = (Employee) obj;
		return id == employee.id;
	}
}
