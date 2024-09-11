package de.oszimt.fian.hase.model.customer;

import de.oszimt.fian.hase.interfaces.IntCustomerMgmt;
import de.oszimt.fian.hase.model.Address;
import de.oszimt.fian.hase.model.HaseGmbHManagement;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerMgmt implements IntCustomerMgmt {

    private final ArrayList<Customer> customerList;
    private final HaseGmbHManagement model;

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
        customer = new Customer(getNextFreeId(), "Karin", "Nielsen", LocalDate.of(1970, 3, 21), "nielsen@acidlsdshop.com",
                new Address("Zornige Ameise", "2", "45134", "Essen"));
        add(customer);

        customer = new Customer(getNextFreeId(), "Timon", "Klier", LocalDate.of(1968, 8, 11), "klier68@gmail.com",
                new Address("Spar dir die Müh","4", "38685", "Langelsheim"));
        add(customer);

        customer = new Customer(getNextFreeId(), "Egon", "Diederichsen", LocalDate.of(1975, 7, 4), "egondiederichsen@gmail.com",
                new Address("Loretostraße", "29", "10119", "Berlin"));
        add(customer);

        customer = new Customer(getNextFreeId(), "Thore", "Rogowski", LocalDate.of(1963, 5, 14), "rogowski@ebarg.net",
                new Address("Hölle","6", "25746", "Heide"));
        add(customer);

        customer = new Customer(getNextFreeId(), "Jan-Hendrik", "Kohnen", LocalDate.of(1985, 9, 2), "kohnen@gmx.net",
                new Address("Auf der Kegelbahn", "7", "53925", "Kall"));
        add(customer);

        customer = new Customer(getNextFreeId(), "Nils", "Mantel", LocalDate.of(1955, 6, 19), "mantel@btcmail.org",
                new Address("Kleines Berg","5a", "16227", "Eberswalde"));
        add(customer);

        customer = new Customer(getNextFreeId(), "Kai", "Wiese", LocalDate.of(1973, 4, 26), "wiese.kai@webmail.de",
                new Address("Unter Fettenhennen","11", "50667", "Köln"));
        add(customer);

        customer = new Customer(getNextFreeId(), "Ali", "Gator", LocalDate.of(1972, 1, 20), "ali.gator@web.de",
                new Address("L7,","8", "68165", "Mannheim"));
        add(customer);



    }
}
