package org.ies.tierno.objects.bank.app;

import org.ies.tierno.objects.bank.model.Account;
import org.ies.tierno.objects.bank.model.Bank;
import org.ies.tierno.objects.bank.readers.AccountReader;
import org.ies.tierno.objects.bank.readers.BankReader;
import org.ies.tierno.objects.bank.readers.CustomerReader;

import java.util.Scanner;

public class BankApp2 {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        var customerReaer = new CustomerReader(scanner);
        var accountReader = new AccountReader(scanner, customerReaer);
        var bankReader = new BankReader(scanner, accountReader);

        Bank bank = bankReader.read();

        Account a = bank.accountWithIban(Bank.getIban());
        a.withdraw(50);

        Account a2 = bank.accountWithIban(Bank.getIban());
        a2.deposit(300);


        Account a1 = bank.accountWithIban(bank.getIban());
        a1.getCustomer().showInfo();
    }
}
