package de.oszimt.fian.hase.model.contract;

import de.oszimt.fian.hase.interfaces.IntContractMgmt;
import de.oszimt.fian.hase.model.ActivityRecord;
import de.oszimt.fian.hase.model.HaseGmbHManagement;

import java.util.ArrayList;
import java.util.Collection;

public class ContractMgmt implements IntContractMgmt {
    private final HaseGmbHManagement model;

    public ContractMgmt(HaseGmbHManagement model) {
        this.model = model;
    }

    //
    // implementation of interface IntContractMgmt
    //
    //

    @Override
    public boolean add(Contract contract) {
        return false;
    }

    @Override
    public Contract get(int id) {
        return null;
    }

    @Override
    public Collection<Contract> getAll() {
        model.getView().showError("Wird erst in A3.1 implementiert");
        return new ArrayList<>();
    }

    @Override
    public boolean update(Contract contract) {
        return false;
    }

    @Override
    public boolean addNewWorkingRecord(int contractID, ActivityRecord aRecord) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    public HaseGmbHManagement getModel() {
        return model;
    }

    @Override
    public int getNextFreeId() {
        return 0;
    }

    /**
     * Return the numbers of contract
     * @return size
     */
    public int size(){
        return 0;
    }

    public void loadData() {

    }
}
