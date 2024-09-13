package de.oszimt.fian.hase.model.contract;

import de.oszimt.fian.hase.interfaces.IntContractMgmt;
import de.oszimt.fian.hase.model.ActivityRecord;
import de.oszimt.fian.hase.model.Address;
import de.oszimt.fian.hase.model.HaseGmbHManagement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ContractMgmt implements IntContractMgmt {
    private final ArrayList<Contract> contractList;
    private final HaseGmbHManagement model;

    public ContractMgmt(HaseGmbHManagement model) {
        this.contractList = new ArrayList<>();
        this.model = model;
    }

    //
    // implementation of interface IntContractMgmt
    //
    //

    @Override
    public boolean add(Contract contract) {
        for (Contract c : contractList)
            if (c.equals(contract)) {
                getModel().getView().showError("Error: contract "+contract.getId()+" id in used.");
                return false;
            }
        contractList.add(contract);
        return true;
    }

    @Override
    public Contract get(int id) {
        for (Contract c : contractList)
            if (c.getId() == id) {
                return c;
            }
        getModel().getView().showError("Error: contract "+id+" does not exist.");
        return null;
    }

    @Override
    public ArrayList<Contract> getAll() {
        return contractList;
    }

    @Override
    public boolean update(Contract contract) {
        for (int i = 0; i < contractList.size(); i++)
            if (contractList.get(i).equals(contract)) {
                contractList.set(i, contract);
                return true;
            }
        getModel().getView().showError("Error: contract "+contract.getId()+" does not exist.");
        return false;
    }

    @Override
    public boolean addNewWorkingRecord(int contractID, ActivityRecord aRecord) {
        Contract aContract = get(contractID);
        if (aContract != null)
            if (aContract.getActivityRecordList() != null) {
                aContract.getActivityRecordList().add(aRecord);
                return true;
            }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < contractList.size(); i++)
            if (contractList.get(i).getId() == id) {
                contractList.remove(i);
                return true;
            }
        getModel().getView().showError("Error: contract "+id+" does not exist.");
        return false;
    }

    public HaseGmbHManagement getModel() {
        return model;
    }

    @Override
    public int getNextFreeId() {
        return contractList.size();
    }

    public void loadData() {
        // creating some ActivityRecords

        // for the contract 100001
        ActivityRecord ar01 = new ActivityRecord(LocalDate.of(2022, 6, 3), LocalTime.of(8, 30), LocalTime.of(13, 0),
                getModel().getEmployee().get(0), "Entplumpung der Plumpen");
        ActivityRecord ar02 = new ActivityRecord(LocalDate.of(2022, 6, 11), LocalTime.of(10, 15), LocalTime.of(14, 30),
                getModel().getEmployee().get(0), "Sägearbeiten angeschnitten");

        ActivityRecord ar03 = new ActivityRecord(LocalDate.of(2022, 6, 11), LocalTime.of(10, 15), LocalTime.of(14, 30),
                getModel().getEmployee().get(1), "Baumfällarbeiten");
        ActivityRecord ar04 = new ActivityRecord(LocalDate.of(2022, 6, 12), LocalTime.of(9, 0), LocalTime.of(11, 30),
                getModel().getEmployee().get(1), "Whirlpool säubern");

        // for contract 100002
        ActivityRecord ar05 = new ActivityRecord(LocalDate.of(2022, 7, 17), LocalTime.of(14, 30), LocalTime.of(17, 0),
                getModel().getEmployee().get(2), "Wasserschaden verursacht");
        ActivityRecord ar06 = new ActivityRecord(LocalDate.of(2022, 7, 19), LocalTime.of(9, 30), LocalTime.of(15, 0),
                getModel().getEmployee().get(2), "Erweiterung Schwimmbecken");

        // Employee 1004
        ActivityRecord ar07 = new ActivityRecord(LocalDate.of(2022, 7, 20), LocalTime.of(14, 30), LocalTime.of(17, 0),
                getModel().getEmployee().get(3), "Entgräten von Fischgräten");

        ActivityRecord ar08 = new ActivityRecord(LocalDate.of(2022, 8, 2), LocalTime.of(9, 30), LocalTime.of(15, 0),
                getModel().getEmployee().get(3), "Neuen Wasseranschluss legen");

        // creating some activity lists
        ArrayList<ActivityRecord> arList01 = new ArrayList<>();
        arList01.add(ar01);
        arList01.add(ar02);
        arList01.add(ar03);
        arList01.add(ar04);

        ArrayList<ActivityRecord> arList02 = new ArrayList<>();
        arList02.add(ar05);
        arList02.add(ar06);
        arList02.add(ar07);
        arList02.add(ar08);

        // initialisation of contracts

        Contract contract;
        contract = new Contract(getNextFreeId(), LocalDate.of(2022, 4, 10),
                new Address("Theodor-Storm-Straße", "23", "73529", "Berlin"), getModel().getCustomer().get(0),
                getModel().getEmployee().get(0), "Wartung", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit.", arList01);
        add(contract);

        contract = new Contract(getNextFreeId(), LocalDate.of(2022, 2, 10),
                new Address("Theodor-Storm-Straße", "23", "73529", "Berlin"), getModel().getCustomer().get(0),
                getModel().getEmployee().get(0), "Wartung", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit.", arList02);
        add(contract);

        Contract contract1 = new Contract(getNextFreeId(), LocalDate.of(2022, 4, 10),
                new Address("Zornige Ameise", "2", "45134", "Essen"), getModel().getCustomer().get(0),
                getModel().getEmployee().get(0), "Wartung", "Yar Pirate Ipsum", arList01);
        add(contract1);

        Contract contract2 = new Contract(getNextFreeId(), LocalDate.of(2022, 5, 22),
                new Address("Auf der Kegelbahn", "7", "53925", "Kall"), getModel().getCustomer().get(4),
                getModel().getEmployee().get(0), "Reparatur", "Cupcake ipsum dolor sit amet", arList02);
        add(contract2);
    }
}
