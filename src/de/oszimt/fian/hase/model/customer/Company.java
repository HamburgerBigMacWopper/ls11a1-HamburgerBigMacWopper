package de.oszimt.fian.hase.model.customer;

import de.oszimt.fian.hase.model.Address;

import java.time.LocalDate;

public class Company extends Customer {
    private int creditLimit;
    private String name;

    public Company(int id, String name, String firstname, String lastname, String email,
                    Address address) {
        super(id, firstname, lastname, email, address);
        this.creditLimit = 0;
        this.name = name;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLabel() {
        String returnstring = "";
        returnstring += name;
        returnstring += "\nz.Hd. " + super.firstname + " " + super.lastname;
        returnstring += "\n" + super.address.toString();
        return returnstring;
    }

    public boolean isAutomaticOrderVolume(int orderVolume) {
        int bonus = 0;
        if (super.status == 'S') {
            bonus = 5000;
        }
        bonus += creditLimit;
        if (super.paymentType == 'V' || super.paymentType == 'N') {
            return true;
        } else if (super.paymentType == 'R' && orderVolume <= 2500 + bonus) {
            return true;
        } else if ((super.paymentType == 'L'|| super.paymentType == 'O') && orderVolume <= 1000 + bonus) {
            return true;
        }
        return false;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company tempPerson = (Company) o;
        return this.id == tempPerson.getId();
    }

    @Override
    public String toString() {
        String returnstring = "";
        returnstring += "Customer [customerID=: " + super.getId();
        returnstring += ", firstname=" + super.getFirstname();
        returnstring += ", lastname= " + super.getLastname();
        returnstring += ", email=" + super.getEmail();
        returnstring += ", address=" + super.address;
        returnstring += ", creditLimit=" + creditLimit;
        returnstring += ", name=" + name;
        returnstring += ", status=" + super.status;
        returnstring += ", paymentType=" + super.paymentType;
        returnstring += "]";
        return returnstring;
    }
}
