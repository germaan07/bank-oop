package org.ies.tierno.objects.bank.readers;

import org.ies.tierno.objects.bank.model.Account;
import org.ies.tierno.objects.bank.model.Bank;

import java.util.Scanner;

public class BankReader {
    private final Scanner scanner;
    private final AccountReader accountReader;

    public BankReader(Scanner scanner, AccountReader accountReader) {
        this.scanner = scanner;
        this.accountReader = accountReader;
    }

    public Bank read() {
        System.out.println("Introduce los datos del banco");
        System.out.print("Nombre: ");
        String name = scanner.nextLine();

        int numAccounts;
        do {
            System.out.print("Número de Cuentas: ");
            numAccounts = scanner.nextInt();
            scanner.nextLine();
        } while (numAccounts < 1);

        Account[] accounts = new Account[numAccounts];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = accountReader.read();
        }

        return new Bank(
                name,
                accounts
        );
    }
}
