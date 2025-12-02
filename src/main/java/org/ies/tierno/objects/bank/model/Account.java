package org.ies.tierno.objects.bank.model;

import java.util.Objects;

public class Account {
    private String iban;
    private double balance;
    private Customer customer;

    public Account(String iban, double balance, Customer customer) {
        this.iban = iban;
        this.balance = balance;
        this.customer = customer;
    }


    public final void showInfo(){
        System.out.println("    IBAN: " + iban);
        System.out.println("    Saldo: " + balance);
        System.out.println("    Información Del Cliente: ");
        customer.showInfo();
    }


    public final boolean custormerWithNif(String nif){
        if (customer.getNif().equals(nif)){
            return true;
        }
        return false;
    }


    public final boolean checkBalance(double balance){
        if (balance < 0){
            System.out.print("No se puede realizar la acción, pues el ordenante no tiene el suficiente saldo en la cuenta.");
            return false;
        }
        return true;
    }


    public void deposit(double cant){
        balance = balance + cant;
    }


    public void withdraw(double cant){
        var finalBalance = balance - cant;

        if (checkBalance(finalBalance)){
            balance = balance - cant;
        }
    }


    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(balance, account.balance) == 0 && Objects.equals(iban, account.iban) && Objects.equals(customer, account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, balance, customer);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}
