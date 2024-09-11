package de.oszimt.fian.hase.model.employee;

import de.oszimt.fian.hase.interfaces.IntEmployeeMgmt;
import de.oszimt.fian.hase.model.HaseGmbHManagement;

import java.util.HashMap;
import java.util.Collection;

public class EmployeeMgmt implements IntEmployeeMgmt {

	private final HashMap<Integer, Employee> employeeList;
	private final HaseGmbHManagement model;

	public EmployeeMgmt(HaseGmbHManagement model) {
		this.employeeList = new HashMap<>();
		this.model = model;
	}

	//
	// implementation of interface IntEmployeeMgmt
	//

	@Override
	public boolean add(Employee employee) {
		employeeList.put(employee.getId(), employee);
		//employeeList[employee.getId()] = employee;
		return true;
	}

	/**
	 * Returns the employee whose ID was passed as a parameter
	 * @param id, id of the employee
	 * @return an object of class Employee
	 */
	@Override
	public Employee get(int id) {
		if (employeeList.get(id) == null) {
			return null;
		} else {
			return employeeList.get(id);
		}
	}

	@Override
	public Collection<Employee> getAll() {
		return employeeList.values();
	}

	@Override
	public boolean update(Employee employee) {
		employeeList.put(employee.getId(), employee);
		return true;
	}

	@Override
	public boolean delete(int id) {
		employeeList.remove(id);
		return true;
	}

	public HaseGmbHManagement getModel() {
		return model;
	}

	@Override
	public int getNextFreeId() {
		int i = 1;
		while (employeeList.containsKey(i)) {
			i++;
		}
		return i;
	}

	/**
	 * Return the numbers of employees
	 * @return size
	 */
	public int size(){
		return employeeList.size();
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
