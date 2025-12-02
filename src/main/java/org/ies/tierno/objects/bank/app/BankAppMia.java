package org.ies.tierno.objects.bank.app;

import org.ies.tierno.objects.bank.model.Account;
import org.ies.tierno.objects.bank.model.Bank;
import org.ies.tierno.objects.bank.readers.AccountReader;
import org.ies.tierno.objects.bank.readers.BankReader;
import org.ies.tierno.objects.bank.readers.CustomerReader;

import java.util.Scanner;

public class BankAppMia {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CustomerReader customerReaer = new CustomerReader(scanner);
    private static final AccountReader accountReader = new AccountReader(scanner, customerReaer);
    private static final BankReader bankReader = new BankReader(scanner, accountReader);

    public static void main(String[] args) {
        Bank bank = bankReader.read();
        boolean cont = true;

        do {
            printMenu();
            var option = selectOption();

            if (option == 1) {
                bank.showInfo();

            } else if (option == 2) {
                String iban = bank.getIban();
                bank.accountWithIban(iban).showInfo();

            } else if (option == 3) {
                String nif = bank.getANif();
                bank.aWithNif(nif);

            } else if (option == 4) {
                bank.depositSald(bank.getIban());

            } else if (option == 5) {
                bank.numCounts(bank.getANif());

            } else if (option == 6) {
                bank.customerWithIban(bank.getIban());

            } else if (option == 7) {
                bank.transfer(bank.accountWithIban(Bank.getIban()), bank.accountWithIban(Bank.getIban()), bank.cantTrans());

            } else if (option == 8) {
                cont = false;
            } else {
                System.out.println("Opción inválida, por favor introduzca una opción válida que esté en el menú.");
            }
        } while (cont);

        System.out.println("Saliendo del programa.");
    }


    public static final void printMenu() {
        System.out.println("OPCIONES A HACER");
        System.out.println("1. Mostrar todas las Cuentas.");
        System.out.println("2. Buscar Cuentas por IBAN.");
        System.out.println("3. Buscar Cuentas por NIF.");
        System.out.println("4. Ingresar dinero en Cuenta (mediante IBAN).");
        System.out.println("5. Números de cuenta de un Cliente (mediante NIF.)");
        System.out.println("6. Mostrar datos de un Cliente (mediante IBAN)");
        System.out.println("7. Realizar transferecia entre cuentas.");
        System.out.println("9. Salir");
    }


    public static final int selectOption() {
        System.out.print("Introduce la opción que desea realizar: ");
        var opt = scanner.nextInt();
        scanner.nextLine();
        return opt;
    }
}