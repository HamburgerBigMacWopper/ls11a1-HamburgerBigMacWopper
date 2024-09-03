package de.oszimt.fian.hase.interfaces;
import de.oszimt.fian.hase.model.employee.Employee;

import java.util.Collection;

public interface IntEmployeeMgmt {
		
	/**
	 * add a new employee 
	 * @param employee
	 * @return true = was successfull, false = otherwise
	 */
	boolean add(Employee employee);
  
	/**
	 * Returns the employee whose ID was passed as a parameter
	 * @param id, id of the employee
	 * @return an object of class Employee
	 */
	Employee get(int id);
	
	/**
	 * Returns a list with all employees
	 * @return {@link Collection}
	 */
	Collection<Employee> getAll();
	
	/**
	 * Replaces an existing employee with the employee 
	 * which was transferred as a parameter
	 * @param employee
	 * @return true, if it was successful, false otherwise
	 */
	boolean update(Employee employee);
	
	/**
	 * Removes an existing employee
	 * @param id, an id
	 * @return true if it was successful, false otherwise
	 */
	boolean delete(int id);

	/**
	 * Return the next free id
	 * @return next id
	 */
	int getNextFreeId();

}
