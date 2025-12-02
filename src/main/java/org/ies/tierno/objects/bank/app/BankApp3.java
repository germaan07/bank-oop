package org.ies.tierno.objects.bank.app;

import org.ies.tierno.objects.bank.model.Bank;
import org.ies.tierno.objects.bank.readers.AccountReader;
import org.ies.tierno.objects.bank.readers.BankReader;
import org.ies.tierno.objects.bank.readers.CustomerReader;

import java.util.Scanner;

public class BankApp3 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var customerReaer = new CustomerReader(scanner);
        var accountReader = new AccountReader(scanner, customerReaer);
        var bankReader = new BankReader(scanner, accountReader);

        Bank bank = bankReader.read();

        var account = bank.accountWithIban(Bank.getIban());

        var a2 = bank.accountWithIban(bank.getIban());

        bank.transfer(account, a2, account.getBalance());
        bank.showInfo();
    }
}
