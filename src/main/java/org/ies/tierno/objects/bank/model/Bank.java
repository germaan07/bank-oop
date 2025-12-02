package org.ies.tierno.objects.bank.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Bank {
    private String name;
    private Account[] accounts;

    private final static Scanner scanner = new Scanner(System.in);

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }


    public final void showInfo(){
        System.out.println("        " + name.toUpperCase() + "      ");
        System.out.println("Número de cuentas: " + accounts.length);
        var cont = 1;
        for (Account a : accounts){
            System.out.println("DATOS DE LA CUENTA " + cont);
            cont++;
            a.showInfo();
        }
    }


    public static String getANif() {
        System.out.print("Introduce el NIF: ");
        String nif = scanner.nextLine();
        return nif;
    }

    public static String getIban() {
        System.out.print("Introduce el IBAN de la cuenta: ");
        String iban = scanner.nextLine();
        return iban;
    }


    public final Account accountWithIban(String iban){
        for (Account a : accounts){
            if (a.getIban().equals(iban)){
                return a;
            }
        }
        System.out.println("Cuenta no encontrada.");
        return null;
    }


    public final void aWithNif(String nif){
        boolean found = false;

        for (Account a : accounts){
            if (a.custormerWithNif(nif)){
                a.showInfo();
                found = true;
            }
        }
        if (!found){
            System.out.println("Cuenta no encontrada.");
        }
    }


    public final void depositSald(String iban){
        Account account = accountWithIban(iban);
        account.deposit(getCant());
    }

    private int getCant(){
        var cant = 0;
        do {
            System.out.print("Introduce la cantidad que desea ingresar (debe ser mayor a cero): ");
            cant = scanner.nextInt();
            scanner.nextLine();
        } while (cant < 1);
        return cant;
    }


    public final double cantTrans(){
        var cont = false;
        do {
            System.out.print("Introduce la cantidad de la transacción (MAYOR QUE 0€): ");
            var cant = scanner.nextDouble();
            scanner.nextLine();

            if (cant > 0){
                cont = true;
                return cant;
            }
        } while (!cont);
        return 0;
    }


    public final void numCounts(String nif){
        var cont = 0;
        for (Account a : accounts){
            if (a.custormerWithNif(nif)){
                cont++;
            }
        }
        if (cont == 0){
            System.out.println("Este NIF no se encuentra en nuestra base de datos, por favor, compruébelo.");
        } else {
            System.out.println("El cliente tiene: " + cont + " cuentas.");
        }
    }


    public final Customer customerWithIban(String iban){
        var account = accountWithIban(iban);
        if (account != null){
            return account.getCustomer();
        }
        return null;
    }


    public final void transfer(Account payer, Account payee, double cant){

        boolean cont = true;

        System.out.print("Cuenta ORDENANTE " + payer.getIban());

        System.out.println("Cuenta BENEFICIARIA " + payee.getIban());

        System.out.print("CANTIDAD DE LA TRANSACCIÓN: ");
        cant = scanner.nextDouble();
        scanner.nextLine();

        payer.withdraw(cant);
        payee.deposit(cant);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
