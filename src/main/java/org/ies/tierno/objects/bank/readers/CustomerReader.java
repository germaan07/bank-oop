package org.ies.tierno.objects.bank.readers;

import org.ies.tierno.objects.bank.model.Customer;

import java.util.Scanner;

public class CustomerReader {
    private final Scanner scanner;

    public CustomerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Customer read(){
        System.out.println("Introduce los datos del cliente");
        System.out.print("NIF: ");
        String nif = scanner.nextLine();

        System.out.print("Nombre: ");
        String name = scanner.nextLine();

        System.out.print("Apellidos: ");
        String surname = scanner.nextLine();

        return new Customer(
                nif,
                name,
                surname
        );
    }
}
