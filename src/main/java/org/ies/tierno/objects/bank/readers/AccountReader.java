package org.ies.tierno.objects.bank.readers;

import org.ies.tierno.objects.bank.model.Account;
import org.ies.tierno.objects.bank.model.Customer;

import java.util.Scanner;

public class AccountReader {
    private final Scanner scanner;
    private final CustomerReader customerReader;

    public AccountReader(Scanner scanner, CustomerReader customerReader) {
        this.scanner = scanner;
        this.customerReader = customerReader;
    }

    public Account read() {
        System.out.println("Introduce los datos de la cuenta");
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();

        System.out.print("Saldo: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        Customer customer = customerReader.read();

        return new Account(
                iban,
                balance,
                customer
        );
    }
}
