package de.oszimt.fian.hase.model.customer;

import de.oszimt.fian.hase.interfaces.IntCustomerMgmt;
import de.oszimt.fian.hase.model.Address;
import de.oszimt.fian.hase.model.HaseGmbHManagement;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerMgmt implements IntCustomerMgmt {

    private ArrayList<Customer> customerList;
    private HaseGmbHManagement model;

    public CustomerMgmt(HaseGmbHManagement model) {
        this.customerList = new ArrayList<>();
        this.model = model;
    }

    //
    // implementation of interface IntCustomerMgmt
    //
    //

    @Override
    public boolean add(Customer customer) {
        for (Customer c : customerList)
            if (c.equals(customer)) {
                getModel().getView().showError("Error: customer "+ customer +" in used.");
                return false;
            }
        customerList.add(customer);
        return true;

    }

    @Override
    public Customer get(int id) {
        for (Customer c : customerList)
            if (c.getId() == id) {
                return c;
            }
        getModel().getView().showError("Error: customer "+ id +" does not exist.");
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() {
        return customerList;
    }

    @Override
    public boolean update(Customer customer) {
        for (int i = 0; i < customerList.size(); i++)
            if (customerList.get(i).equals(customer)) {
                customerList.set(i, customer);
                return true;
            }
        getModel().getView().showError("Error: customer "+ customer +" does not exist.");
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < customerList.size(); i++)
            if (customerList.get(i).getId() == id) {
                customerList.remove(i);
                return true;
            }
        getModel().getView().showError("Error: customer "+ id +" does not exist.");
        return false;
    }

    public HaseGmbHManagement getModel() {
        return model;
    }

    @Override
    public int getNextFreeId() {
        return customerList.size();
    }

    public void loadData() {

        Customer customer;
        customer = new Consumer(getNextFreeId(), "Karin", "Nielsen", LocalDate.of(1970, 3, 21), "nielsen@acidlsdshop.com",
                new Address("Theodor-Storm-Straße", "23", "73529", "Berlin"));
        add(customer);

        customer = new Consumer(getNextFreeId(), "Timon", "Klier", LocalDate.of(1968, 8, 11), "klier68@gmail.com",
                new Address("Lübzer Straße", "6", "12529", "Berlin"));
        add(customer);

        customer = new Consumer(getNextFreeId(), "Egon", "Diederichsen", LocalDate.of(1975, 7, 4), "egondiederichsen@gmail.com",
                new Address("Loretostraße", "29", "10119", "Berlin"));
        add(customer);

        customer = new Consumer(getNextFreeId(), "Thore", "Rogowski", LocalDate.of(1963, 5, 14), "rogowski@ebarg.net",
                new Address("Sandäckerstraße", "25", "14537", "Berlin"));
        add(customer);

        customer = new Consumer(getNextFreeId(), "Jan-Hendrik", "Kohnen", LocalDate.of(1985, 9, 2), "kohnen@gmx.net",
                new Address("Pfarrer-Baumann-Straße", "9", "10577", "Berlin"));
        add(customer);

        customer = new Consumer(getNextFreeId(), "Nils", "Mantel", LocalDate.of(1955, 6, 19), "mantel@btcmail.org",
                new Address("Kattenescher Weg", "25", "13657", "Berlin"));
        add(customer);

        customer = new Consumer(getNextFreeId(), "Kai", "Wiese", LocalDate.of(1973, 4, 26), "wiese.kai@webmail.de",
                new Address("Dr.-Heffner-Straße", "33", "14112", "Berlin"));
        add(customer);

        //add companies
        customer = new Company(4, "Fliesenzentrum Peter Platten", "Peter", "Platten", "platten@fliesenzentrumplatten.de", new Address("Geil", "5","24960", "Munkbrarup"));
        add(customer);

        customer = new Company(4, "Rost & Söhne", "Lisa ", "Bonn", "bonn@rostundsoehne.de", new Address("Spar dir die Müh", "4","38685", "Langelsheim"));
        add(customer);


    }
}
