package de.oszimt.fian.hase.interfaces;
import de.oszimt.fian.hase.model.ActivityRecord;
import de.oszimt.fian.hase.model.contract.Contract;

import java.util.Collection;

public interface IntContractMgmt {
	
	/**
	 * add a new contract 
	 * @param contract, to add
	 */
	boolean add(Contract contract);
  
	/**
	 * Returns the contract whose ID was passed as a parameter
	 * @param id of the element
	 * @return a contract object
	 */
	Contract get(int id);
	
	/**
	 * Returns a list with all contracts
	 * @return {@link Collection}
	 */
	Collection<Contract> getAll();
	
	/**
	 * Replaces an existing contract with the contract 
	 * which was transferred as a parameter
	 * @param contract to update
	 * @return true if it was successful, else false
	 */
	boolean update(Contract contract);
	
	boolean addNewWorkingRecord(int contractID, ActivityRecord aRecord);
	
	/**
	 * Removes an existing contract
	 * @param id of the element
	 * @return true if it was successful, false otherwise
	 */
	boolean delete(int id);

	/**
	 * Return the next free id
	 * @return next id
	 */
	int getNextFreeId();

}
