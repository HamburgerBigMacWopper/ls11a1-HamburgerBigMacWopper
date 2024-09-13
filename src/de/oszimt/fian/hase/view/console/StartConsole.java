package de.oszimt.fian.hase.view.console;

import de.oszimt.fian.hase.model.HaseGmbHManagement;
import de.oszimt.fian.hase.model.contract.Contract;
import de.oszimt.fian.hase.model.employee.Employee;
import de.oszimt.fian.hase.view.IntView;
import de.oszimt.fian.hase.model.customer.Customer;

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
            ConsoleHelper.printMenu(-1, "Beenden");
            int i = ConsoleHelper.inputInt("Ihre Wahl", -1, 4);
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

    }

    public void removeCustomer() {
        ConsoleHelper.header("Kunden einfach entfernen");

        for (Customer customer : model.getCustomer().getAll()) {
            ConsoleHelper.printMenu(customer.getId(), customer.toString());
        }
        int customerId = ConsoleHelper.inputInt("ID des zum sterbenden Kunden", 0, model.getCustomer().getNextFreeId() - 1);

        ConsoleHelper.valid("Gelöscht: " + model.getCustomer().get(customerId), model.getCustomer().delete(customerId));
        model.getContract().delete(customerId);

        mainmenu();
    }
}
