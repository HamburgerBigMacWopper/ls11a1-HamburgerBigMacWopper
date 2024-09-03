package de.oszimt.fian.hase.view.console;

import de.oszimt.fian.hase.model.HaseGmbHManagement;
import de.oszimt.fian.hase.model.contract.Contract;
import de.oszimt.fian.hase.model.employee.Employee;
import de.oszimt.fian.hase.view.IntView;

public class StartConsole implements IntView {

    HaseGmbHManagement model;

    @Override
    public void show(HaseGmbHManagement model) {
        this.model = model;
        mainmenu();
    }

    public void mainmenu(){
        ConsoleHelper.header("Willkommen bei der Handwerker Service Eulenstein GmbH");
        ConsoleHelper.printMenu(0,"Mitarbeiter anzeigen");
        ConsoleHelper.printMenu(1,"Mitarbeiter hinzufügen");
        ConsoleHelper.printMenu(2,"Mitarbeiter löschen");
        ConsoleHelper.printMenu(3,"Kunden anzeigen");
        ConsoleHelper.printMenu(4,"Verträge anzeigen");
        int i = ConsoleHelper.inputInt("Ihre Wahl",0,4);
        switch (i) {
            case 0: showEmployee(); break;
            case 1: addEmployee(); break;
            case 2: removeEmployee(); break;
            case 3: showCustomer(); break;
            case 4: showContract(); break;
            default: showError("Menüpunkt "+i+" nicht bekannt."); mainmenu(); break;
        }

    }

    @Override
    public void showError(String mess) {
        Throwable t = new Throwable();
        System.err.println(mess+" : "+t.getStackTrace()[1] + "/"+t.getStackTrace()[2]);
    }

    public void showEmployee(){
        ConsoleHelper.header("Alle Mitarbeiter");
        for (Employee c : model.getEmployee().getAll()) {
            System.out.println(c);
        }

        mainmenu(); //zurück zum hauptmenü
    }

    public void addEmployee(){
        ConsoleHelper.header("Mitarbeiter hinzufügen");
        String firstName = ConsoleHelper.input("Vorname");
        String lastName = ConsoleHelper.input("Nachname");
        String email = ConsoleHelper.input("E-Mail");
        String tel = ConsoleHelper.input("Telefon");

        Employee e = new Employee(model.getEmployee().getNextFreeId(), firstName, lastName, email, tel);
        ConsoleHelper.valid("Neu: "+e, model.getEmployee().add(e)); // add a employee and print the result

        mainmenu(); //zurück zum hauptmenü
    }

    public void removeEmployee(){
        ConsoleHelper.header("Mitarbeiter entfernen");
        for (Employee c : model.getEmployee().getAll()) {
            ConsoleHelper.printMenu(c.getId(), c.toString());
        }
        int i = ConsoleHelper.inputInt("ID des zu löschenden Mitarbeiter",0,model.getEmployee().getNextFreeId()-1);
        ConsoleHelper.valid("Gelöscht: "+model.getEmployee().get(i), model.getEmployee().delete(i));

        mainmenu(); //zurück zum hauptmenü
    }

    public void showCustomer(){
        ConsoleHelper.header("Alle Kunden");
        model.getCustomer().getAll().forEach(System.out::println);
        mainmenu();
    }

    public void showContract(){
        ConsoleHelper.header("Alle Verträge");
        for (Contract c : model.getContract().getAll()) {
            System.out.println(c);
        }
        mainmenu();
    }
}
