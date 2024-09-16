package de.oszimt.fian.hase.view.console;

import de.oszimt.fian.hase.model.HaseGmbHManagement;
import de.oszimt.fian.hase.model.contract.Contract;
import de.oszimt.fian.hase.model.contract.ContractMgmt;
import de.oszimt.fian.hase.model.employee.Employee;
import de.oszimt.fian.hase.view.IntView;
import de.oszimt.fian.hase.model.customer.Customer;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * Show the main menu on a console in a loop
 * @version 240912
 * @author Steffen Trutz
 */
public class StartConsole implements IntView {

    HaseGmbHManagement model;

    @Override
    public void show(HaseGmbHManagement model) {
        this.model = model;
        mainmenu();
    }

    /**
     * Show the main menu in a loop
     */
    public void mainmenu() {
        while (true) {
            ConsoleHelper.header("Willkommen bei der Handwerker Service Eulenstein GmbH");
            ConsoleHelper.printMenu(0, "Mitarbeiter anzeigen");
            ConsoleHelper.printMenu(1, "Mitarbeiter hinzufügen");
            ConsoleHelper.printMenu(2, "Mitarbeiter löschen");
            ConsoleHelper.printMenu(3, "Kunden anzeigen");
            ConsoleHelper.printMenu(4, "Verträge anzeigen");
            ConsoleHelper.printMenu(5, "Remove Customer");
            ConsoleHelper.printMenu(6, "Add Contract");
            ConsoleHelper.printMenu(-1, "Beenden");
            int i = ConsoleHelper.inputInt("Ihre Wahl", -1, 6);
            switch (i) {
                case -1 -> {
                    return;
                }
                case 0 -> showEmployee();
                case 1 -> addEmployee();
                case 2 -> removeEmployee();
                case 3 -> showCustomer();
                case 4 -> showContract();
                case 5 -> removeCustomer();
                case 6 -> addContract();
            }
        }
    }

    /**
     * Show a error message
     *
     * @param mess the error message
     */
    @Override
    public void showError(String mess) {
        Throwable t = new Throwable();
        System.err.println(mess + " : " + t.getStackTrace()[1] + "/" + t.getStackTrace()[2]);
    }

    /**
     * Show all employees
     */
    public void showEmployee() {
        ConsoleHelper.header("Alle Mitarbeiter");
        for (Employee c : model.getEmployee().getAll()) {
            System.out.println(c);
        }
    }

    /**
     * Add a employee
     */
    public void addEmployee() {
        ConsoleHelper.header("Mitarbeiter hinzufügen");
        String firstName = ConsoleHelper.input("Vorname");
        String lastName = ConsoleHelper.input("Nachname");
        String email = ConsoleHelper.input("E-Mail");
        String tel = ConsoleHelper.input("Telefon");

        Employee e = new Employee(model.getEmployee().getNextFreeId(), firstName, lastName, email, tel);
        ConsoleHelper.valid("Neu: " + e, model.getEmployee().add(e)); // add an employee and print the result
    }

    /**
     * Remove a employee
     */
    public void removeEmployee() {
        ConsoleHelper.header("Mitarbeiter entfernen");
        for (Employee c : model.getEmployee().getAll()) {
            ConsoleHelper.printMenu(c.getId(), c.toString());
        }
        int i = ConsoleHelper.inputInt("ID des zu löschenden Mitarbeiter", 0, model.getEmployee().getNextFreeId() - 1);
        ConsoleHelper.valid("Gelöscht: " + model.getEmployee().get(i), model.getEmployee().delete(i));
    }

    /**
     * Show all customers
     */
    public void showCustomer() {
        ConsoleHelper.header("Alle Kunden");
        model.getCustomer().getAll().forEach(System.out::println);
    }

    /**
     * Show all contracts
     */
    public void showContract() {
        ConsoleHelper.header("Alle Verträge");
        for (Contract c : model.getContract().getAll()) {
            System.out.println(c);
        }
    }

    public void addContract() {
        ConsoleHelper.header("Contract einfach adden");
        System.out.println("Heute = 0");
        System.out.println("Custom date = 1");
        System.out.println("Main menu = -1");
        int datum_check = ConsoleHelper.inputInt("Heute oder", -1, 1);
        if (datum_check == -1) {
            mainmenu();
        }
        LocalDate creationDate = LocalDate.now();
        if (datum_check != 0) {
            int max_day_month = 31;
            int year = ConsoleHelper.inputInt("Jahr" );
            if (year == -1) {
                mainmenu();
            }
            int month = ConsoleHelper.inputInt("Monat", -1, 12);
            if (month == -1) {
                mainmenu();
            }
            boolean worked = false;
            while (worked == false) {
                try {
                    LocalDate.of(year, month, max_day_month);
                    worked = true;
                } catch (DateTimeException e) {
                    max_day_month--;
                }
            }
            int day = ConsoleHelper.inputInt("Tag", -1, max_day_month);
            if (day == -1) {
                mainmenu();
            }
            creationDate = LocalDate.of(year, month, day);
        }
        //System.out.println(creationDate);
        ConsoleHelper.header("Kunden auswählen");
        int highestid_customer = 0;

        for (Customer customer : model.getCustomer().getAll()) {
            int customerid = customer.getId();
            if (customerid > highestid_customer) {
                highestid_customer = customerid;
            }

            ConsoleHelper.printMenu(customerid, customer.toString());
        }
        System.out.println("-1 = main menu");
        int customerId = ConsoleHelper.inputInt("ID des Kunden", -1, highestid_customer);
        if (customerId == -1) {
            mainmenu();
        }
        Customer customer = model.getCustomer().get(customerId);
        ConsoleHelper.header("Projektowner auswählen");
        int highestid_projektowner = 0;

        for (Employee employee : model.getEmployee().getAll()) {
            int employeeid = employee.getId();
            if (employeeid > highestid_projektowner) {
                highestid_projektowner = employeeid;
            }

            ConsoleHelper.printMenu(employeeid, employee.toString());
        }
        System.out.println("-1 = main menu");
        int projektowner_id = ConsoleHelper.inputInt("ID des Kunden", -1, highestid_projektowner);
        if (customerId == -1) {
            mainmenu();
        }
        Employee projektowner = model.getEmployee().get(projektowner_id);
        ConsoleHelper.header("Contracttype definieren");
        String contractType = "";
        while (contractType == "") {
            contractType = ConsoleHelper.input("Contracttype");
            System.out.println();
        }
        ConsoleHelper.header("Beschreibung definieren");
        String description = ConsoleHelper.input("Description");
        Contract contract = new Contract(model.getContract().getNextFreeId(), creationDate, customer, projektowner, contractType, description);
        model.getContract().add(contract);
    }

    public void removeCustomer() {
        ConsoleHelper.header("Kunden einfach entfernen");
        int highestid = 0;

        for (Customer customer : model.getCustomer().getAll()) {
            int customerid = customer.getId();
            if (customerid > highestid) {
                highestid = customerid;
            }

            ConsoleHelper.printMenu(customerid, customer.toString());
        }
        System.out.println("-1 = zurück");
        int customerId = ConsoleHelper.inputInt("ID des zum sterbenden Kunden", -1, highestid);
        if (customerId == -1) {
            mainmenu();
        }
        for (Contract c : model.getContract().getAll()) {
            if (customerId == c.getCustomer().getId()) {
                c.setCustomer(null);
            }
        }

        ConsoleHelper.valid("Gelöscht: " + model.getCustomer().get(customerId), model.getCustomer().delete(customerId));

        mainmenu();
    }
}
