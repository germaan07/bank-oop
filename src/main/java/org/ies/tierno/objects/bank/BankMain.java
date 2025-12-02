package org.ies.tierno.objects.bank;

import org.ies.tierno.objects.bank.app.BankApp1;
import org.ies.tierno.objects.bank.app.BankApp2;
import org.ies.tierno.objects.bank.app.BankApp3;
import org.ies.tierno.objects.bank.app.BankAppMia;
import org.ies.tierno.objects.bank.model.Bank;
import org.ies.tierno.objects.bank.readers.AccountReader;
import org.ies.tierno.objects.bank.readers.BankReader;
import org.ies.tierno.objects.bank.readers.CustomerReader;

import java.util.Scanner;

public class BankMain {
    private final static Scanner scanner = new Scanner(System.in);
    private final static CustomerReader customerReaer = new CustomerReader(scanner);
    private final static AccountReader accountReader = new AccountReader(scanner, customerReaer);
    private final static BankReader bankReader = new BankReader(scanner, accountReader);

    public static void main(String[] args) {
        Bank bank = bankReader.read();


    }
    public static void menuApps(){
        System.out.println("1. BankApp 1");
        System.out.println("2. BankApp 2");
        System.out.println("3. BankApp 3");
        System.out.println("4. BankApp Beta");
        System.out.println("5. Salir.");
    }

    public static int selectOption(){
        System.out.print("Introduce qué app desea ejecutar:");
        var app = scanner.nextInt();
        scanner.nextLine();
        return app;
    }



    public static void bucleMenu(){
        var continueProgram = true;
        do {
            menuApps();
            var option = selectOption();
            if (option == 1){
                BankApp1;
            } else if (option == 2){
                BankApp2;
            } else if (option == 3) {
                BankApp3;
            } else if (option == 4) {
                BankAppMia;
            } else if (option == 5) {
                System.out.println("Adiós, Saliendo del programa.");
                continueProgram = false;
            } else {
                System.out.println("La opción escogida es incorrecta, por favor, introduce una opción válida.");
            }
        } while (continueProgram);
    }
}
