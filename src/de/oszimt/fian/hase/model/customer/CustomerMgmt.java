package de.oszimt.fian.hase.model.customer;

import de.oszimt.fian.hase.interfaces.IntCustomerMgmt;
import de.oszimt.fian.hase.model.HaseGmbHManagement;

import java.util.ArrayList;
import java.util.Collection;

public class CustomerMgmt implements IntCustomerMgmt {

    private final HaseGmbHManagement model;

    public CustomerMgmt(HaseGmbHManagement model) {
        this.model = model;
    }

    //
    // implementation of interface IntCustomerMgmt
    //
    //

    @Override
    public boolean add(Customer customer) {
        return false;

    }

    @Override
    public Customer get(int id) {
        return null;
    }

    @Override
    public Collection<Customer> getAll() {
        model.getView().showError("Wird erst in A3.1 implementiert");
        return new ArrayList<>();
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    public HaseGmbHManagement getModel() {
        return null;
    }

    @Override
    public int getNextFreeId() {
        return 0;
    }

    /**
     * Return the numbers of customers
     * @return size
     */
    public int size(){
        return 0;
    }

    public void loadData() {

    }
}
