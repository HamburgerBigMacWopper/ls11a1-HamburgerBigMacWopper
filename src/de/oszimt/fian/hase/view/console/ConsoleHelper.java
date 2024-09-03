package de.oszimt.fian.hase.view.console;

import java.util.Scanner;

public class ConsoleHelper {

    /**
     * Print as header formated
     * @param txt to show
     */
    public static void header(String txt){
        System.out.println("-".repeat(txt.length()+4));
        System.out.println("# "+txt+" #");
        System.out.println("-".repeat(txt.length()+4));
    }

    public static String input(String txt){
        System.out.printf("%s: ",txt);
        return new Scanner(System.in).nextLine();
    }
    public static int inputInt(String txt){
        System.out.printf("%s: ",txt);
        try {
            return new Scanner(System.in).nextInt();
        } catch (Throwable t){
            System.out.printf("Bitte Zahl eingeben! (%s: %s)",t.getClass().getSimpleName(), t.getLocalizedMessage());
            System.out.println();
            return inputInt(txt);
        }
    }

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
