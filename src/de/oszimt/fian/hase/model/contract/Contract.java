package de.oszimt.fian.hase.model.contract;

import de.oszimt.fian.hase.model.ActivityRecord;
import de.oszimt.fian.hase.model.Address;
import de.oszimt.fian.hase.model.customer.Customer;
import de.oszimt.fian.hase.model.employee.Employee;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Contract {

	private int id;
	private LocalDate creationDate;
	private Customer customer;
	private Employee projectOwner;
	private String contractType;
	private char State;
	private String description;
	private Address projectLocations;
	private ArrayList<ActivityRecord> activityRecordList;

	public Contract(int id, LocalDate creationDate, Address projectLocations, Customer customer, Employee projectOwner, String contractType, String description) {
		this.id = id;
		this.creationDate = creationDate;
		this.projectLocations = projectLocations;
		this.customer = customer;
		this.projectOwner = projectOwner;
		this.contractType = contractType;
		this.description = description;
	}

	public Contract(int id, LocalDate creationDate, Address projectLocations, Customer customer, Employee projectOwner, String contractType, String description, ArrayList<ActivityRecord> activityRecordList) {
		this.id = id;
		this.creationDate = creationDate;
		this.projectLocations = projectLocations;
		this.customer = customer;
		this.projectOwner = projectOwner;
		this.contractType = contractType;
		this.description = description;
		this.activityRecordList = activityRecordList;
	}

	public Contract() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Contract contract = (Contract) o;
		return id == contract.id && State == contract.State && Objects.equals(creationDate, contract.creationDate) && Objects.equals(customer, contract.customer) && Objects.equals(projectOwner, contract.projectOwner) && Objects.equals(contractType, contract.contractType) && Objects.equals(description, contract.description) && Objects.equals(projectLocations, contract.projectLocations) && Objects.deepEquals(activityRecordList, contract.activityRecordList);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getProjectOwner() {
		return projectOwner;
	}

	public void setProjectOwner(Employee projectOwner) {
		this.projectOwner = projectOwner;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public char getState() {
		return State;
	}

	public void setState(char state) {
		State = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getProjectLocations() {
		return projectLocations;
	}

	public void setProjectLocations(Address projectLocations) {
		this.projectLocations = projectLocations;
	}

	public ArrayList<ActivityRecord> getActivityRecordList() {
		return activityRecordList;
	}

	public void setActivityRecordList(ArrayList<ActivityRecord> activityRecordList) {
		this.activityRecordList = activityRecordList;
	}

	@Override
	public String toString() {
		return "Contract{" +
				"id=" + id +
				", creationDate=" + creationDate +
				", customer=" + customer +
				", projectOwner=" + projectOwner +
				", contractType='" + contractType + '\'' +
				", State=" + State +
				", description='" + description + '\'' +
				", projectLocations=" + projectLocations +
				", activityRecordList=" + activityRecordList +
				'}';
	}
}
