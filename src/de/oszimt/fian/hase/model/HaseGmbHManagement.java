package de.oszimt.fian.hase.model;

import de.oszimt.fian.hase.interfaces.IntContractMgmt;
import de.oszimt.fian.hase.interfaces.IntCustomerMgmt;
import de.oszimt.fian.hase.interfaces.IntEmployeeMgmt;
import de.oszimt.fian.hase.model.contract.ContractMgmt;
import de.oszimt.fian.hase.model.customer.CustomerMgmt;
import de.oszimt.fian.hase.model.employee.EmployeeMgmt;
import de.oszimt.fian.hase.view.IntView;

public class HaseGmbHManagement {

	private final EmployeeMgmt employee;
	private final CustomerMgmt customer;
	private final ContractMgmt contract;

	private final IntView view;

	public HaseGmbHManagement(IntView view) {
		this.view = view;
		this.employee = new EmployeeMgmt(this);
		this.customer = new CustomerMgmt(this);
		this.contract = new ContractMgmt(this);
	}

	public IntView getView() {
		return view;
	}

	public EmployeeMgmt getEmployee() {
		return employee;
	}

	public CustomerMgmt getCustomer() {
		return customer;
	}

	public ContractMgmt getContract() {
		return contract;
	}
}
