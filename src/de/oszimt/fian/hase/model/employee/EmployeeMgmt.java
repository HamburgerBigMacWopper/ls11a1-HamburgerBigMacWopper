package de.oszimt.fian.hase.model.employee;

import de.oszimt.fian.hase.interfaces.IntEmployeeMgmt;
import de.oszimt.fian.hase.model.HaseGmbHManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class EmployeeMgmt implements IntEmployeeMgmt {

	private final Employee [] employeeList;
	private final HaseGmbHManagement model;

	public EmployeeMgmt(HaseGmbHManagement model) {
		this.employeeList = new Employee[5];
		this.model = model;
	}

	//
	// implementation of interface IntEmployeeMgmt
	//

	@Override
	public boolean add(Employee employee) {
		employeeList[employee.getId()] = employee;
		return true;
	}

	/**
	 * Returns the employee whose ID was passed as a parameter
	 * @param id, id of the employee
	 * @return an object of class Employee
	 */
	@Override
	public Employee get(int id) {
		return employeeList[id];
	}

	@Override
	public Collection<Employee> getAll() {
		return new ArrayList<>(Arrays.asList(employeeList));
	}

	@Override
	public boolean update(Employee employee) {
		employeeList[employee.getId()] = employee;
		return true;
	}

	@Override
	public boolean delete(int id) {
		employeeList[id] = null;
		return true;
	}

	public HaseGmbHManagement getModel() {
		return model;
	}

	@Override
	public int getNextFreeId() {
		return employeeList.length;
	}

	/**
	 * Return the numbers of employees
	 * @return size
	 */
	public int size(){
		return employeeList.length;
	}

	// 
	//  methods for installing test data
	//

	public void loadData() {

		Employee anEmployee = new Employee(0, "Max", "Müller", "may.mueller@hase-gmbh.de",	"0049301234545");
		add(anEmployee);

		anEmployee = new Employee(1, "Lennart", "Jäger", "lennart.jaeger@hase-gmbh.de", "00493054234545");
		add(anEmployee);

		anEmployee = new Employee(2, "Silvia", "Schäfers","silvia.schaefers@hase-gmbh.de",	"0049309856749");
		add(anEmployee);

		anEmployee = new Employee(3, "Heiko", "Guempel","heiko.guempel@hase-gmbh.de", "0049303456741");
		add(anEmployee);

		anEmployee = new Employee(4, "Klaus", "Reder", "klaus.reder@hase-gmbh.de", "0049307686231");
		add(anEmployee);

	}

}
