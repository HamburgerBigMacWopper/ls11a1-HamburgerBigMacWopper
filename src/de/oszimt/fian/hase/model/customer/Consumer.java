package de.oszimt.fian.hase.model.customer;

import de.oszimt.fian.hase.model.Address;

import java.time.LocalDate;

public class Consumer extends Customer {
    private LocalDate geburtsdatum;

    public Consumer(int id, String firstname, String lastname, LocalDate geburtsdatum, String email,
                    Address address) {
        super(id, firstname, lastname, email, address);
        this.geburtsdatum = geburtsdatum;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }
    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getAddressLabel() {
        String returnstring = "";
        returnstring += super.firstname + " " + super.lastname;
        returnstring += "\n" + super.address.toString();
        return returnstring;
    }

    public boolean isAutomaticOrderVolume(int orderVolume) {
        int bonus = 0;
        if (super.status == 'S') {
            bonus = 2000;
        }
        if (super.paymentType == 'V' || super.paymentType == 'N') {
            return true;
        } else if (super.paymentType == 'R' && orderVolume <= 500 + bonus) {
            return true;
        } else if ((super.paymentType == 'L'|| super.paymentType == 'O') && orderVolume <= 1000 + bonus) {
            return true;
        }
        return false;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer tempPerson = (Customer) o;
        return this.id == tempPerson.getId();
    }

    @Override
    public String toString() {
        String returnstring = "";
        returnstring += "Consumer [consumerID=: " + super.getId();
        returnstring += ", firstname=" + super.getFirstname();
        returnstring += ", lastname= " + super.getLastname();
        returnstring += ", email=" + super.getEmail();
        returnstring += ", address=" + super.address;
        returnstring += ", status=" + super.status;
        returnstring += ", paymentType=" + super.paymentType;
        returnstring += ", geburtsdatum=" + geburtsdatum;
        returnstring += "]";
        return returnstring;
    }
}
