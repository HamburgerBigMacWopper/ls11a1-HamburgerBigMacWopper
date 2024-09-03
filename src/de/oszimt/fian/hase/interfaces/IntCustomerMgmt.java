package de.oszimt.fian.hase.interfaces;
import de.oszimt.fian.hase.model.customer.Customer;

import java.util.Collection;

public interface IntCustomerMgmt {
	
	/**
	 * Add a new customer 
	 * @param customer
	 */
	boolean add(Customer customer);
  
	/**
	 * Returns the customer whose ID was passed as a parameter
	 * @param id
	 * @return Customer object
	 */
	Customer get(int id);
	
	/**
	 * Returns a list with all customers
	 * @return {@link Collection}
	 */
	Collection<Customer> getAll();
	
	/**
	 * Replaces an existing customer with the customer 
	 * which was transfered as a parameter
	 * @param customer
	 * @return true if it was successful, else false
	 */
	boolean update(Customer customer);
	
	/**
	 * Removes an existing customer
	 * @param id
	 * @return true if it was successful, false otherwise
	 */
	boolean delete(int id);

	/**
	 * Return the next free id
	 * @return next id
	 */
	int getNextFreeId();

}
