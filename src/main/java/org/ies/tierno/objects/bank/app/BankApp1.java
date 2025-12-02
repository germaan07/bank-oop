package org.ies.tierno.objects.bank.app;

import org.ies.tierno.objects.bank.model.Account;
import org.ies.tierno.objects.bank.model.Bank;
import org.ies.tierno.objects.bank.readers.AccountReader;
import org.ies.tierno.objects.bank.readers.BankReader;
import org.ies.tierno.objects.bank.readers.CustomerReader;

import java.util.Scanner;

public class BankApp1 {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        var customerReaer = new CustomerReader(scanner);
        var accountReader = new AccountReader(scanner, customerReaer);
        var bankReader = new BankReader(scanner, accountReader);

        Bank bank = bankReader.read();

        Account a = bank.accountWithIban(Bank.getIban());
        a.deposit(500);

        Account a2 = bank.accountWithIban(Bank.getIban());
        a2.withdraw(30);

        a.showInfo();
        a2.showInfo();
    }
}
