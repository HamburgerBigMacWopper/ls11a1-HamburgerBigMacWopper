package de.oszimt.fian.hase.view.console;

import java.util.Scanner;

/**
 * Helper class for console output
 * @author Steffen
 * @version 240910
 */
public class ConsoleHelper {

    private static Scanner scanner;

    /**
     * Singleton for scanner
     * @return scanner
     */
    private static Scanner getScanner() {
        if (scanner == null)
            scanner = new Scanner(System.in);
        return scanner;
    }

    /**
     * Set the scanner, for debugging/testing only
     * @param scanner to set
     */
    public static void setScanner(Scanner scanner) {
        ConsoleHelper.scanner = scanner;
    }

    /**
     * Print as header formated
     * @param txt to show
     */
    public static void header(String txt){
        System.out.println("+"+"-".repeat(txt.length()+2)+"+");
        System.out.println("| "+txt+" |");
        System.out.println("+"+"-".repeat(txt.length()+2)+"+");
    }

    /**
     * Input a text from the user
     * @param txt, text to show
     * @return the text
     */
    public static String input(String txt){
        System.out.printf("%s: ",txt);
        return getScanner().nextLine();
    }

    /**
     * Input a number from the user
     * @param txt, text to show
     * @return the number
     */
    public static int inputInt(String txt){
        System.out.printf("%s: ",txt);
        try {
            return getScanner().nextInt();
        } catch (Throwable t){
            System.out.printf("Bitte Zahl eingeben! (%s: %s)",t.getClass().getSimpleName(), t.getLocalizedMessage());
            System.out.println();
            return inputInt(txt);
        }
    }

    /**
     * Input a number from the user between min and max
     * @param txt, text to show
     * @param min, minimum included value
     * @param max, maximum included value
     * @return the number
     */
    public static int inputInt(String txt, int min, int max){
        int erg = inputInt(txt+" ["+min+"-"+max+"]");
        if (erg >= min && erg <= max)
            return erg;
        else {
            System.out.printf("Bitte Zahl zwischen %s und %s eingeben!",min, max);
            System.out.println();
            return inputInt(txt, min, max);
        }
    }

    /**
     * Print a menu item
     * @param count, number of the menu item
     * @param txt, text of the menu item
     */
    public static void printMenu(int count, String txt) {
        System.out.printf("[%2s] %s",count,txt);
        System.out.println();
    }

    /**
     * Print a message normal or as error, if success is false
     * @param txt, text to print
     * @param success, if success print normal, otherwise as error
     */
    public static void valid(String txt, boolean success){
        if (success) {
            System.out.println("> Erfolgreich: " + txt);
        } else {
            System.err.println("> Fehler: " + txt);
        }
    }
}
