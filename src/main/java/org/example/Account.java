package org.example;

import java.util.ArrayList;

public class Account {
    private accountType accType;
    private String accountId;
    private String accountUserId;
    private double accountBalance;

    private Registration register;


    private ArrayList<Account> accountsList =new ArrayList<>();

    public Account(){}
    public Account(Registration registration) {
        this.register = registration;
    }
    public Account(accountType accType, String accountId, String accountUserId, double accountBalance , Registration register) {
        this.accType = accType;
        this.accountId = accountId;
        this.accountUserId = accountUserId;
        this.accountBalance = accountBalance;
        this.register=register;
    }


    public void newAccount(accountType accType, String accountId, String accountUserId, double accountBalance){
        accountsList.add(new Account(accType , accountId , accountUserId , accountBalance , register));
    }

    public boolean Deposit(String accountId, double amount, String userId) {

        if (register.getLoggedInUser() == null) {
            System.out.println("Permission denied. You must log in to perform this action.");
            return false;
        }
        for (Account account : accountsList) {
            if (account.getAccountId().equals(accountId)) {
                if (!account.getAccountUserId().equals(userId)) {
                    System.out.println("Permission denied. You don't own this account.");
                    return false;
                }
                double balance = account.getAccountBalance();
                double newBalance = balance + amount;
                account.setAccountBalance(newBalance);
                System.out.println("Deposit successful. New Balance is: " + account.getAccountBalance());
                return true;
            }
        }
        System.out.println("Account not found.");
        return false;
    }
    public boolean Withdraw(String accountId, double amount, String userId) {
        for (Account account : accountsList) {
            if (account.getAccountId().equals(accountId)) {
                if (!account.getAccountUserId().equals(userId)) {
                    System.out.println("Permission denied. You don't own this account.");
                    return false;
                }
                double balance = account.getAccountBalance();
                double newBalance = balance - amount;
                if (newBalance < 0) {
                    System.out.println("Insufficient Funds. Balance is: " + account.getAccountBalance());
                    return false;
                }
                account.setAccountBalance(newBalance);
                System.out.println("Withdrawal successful. New Balance is: " + account.getAccountBalance());
                return true;
            }
        }
        System.out.println("Account not found.");
        return false;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setAccountsList(ArrayList<Account> accountsList) {
        this.accountsList = accountsList;
    }

    public void setAccountUserId(String accountUserId) {
        this.accountUserId = accountUserId;
    }

    public void setAccType(accountType accType) {
        this.accType = accType;
    }

    public accountType getAccType() {
        return accType;
    }

    public ArrayList<Account> getAccountsList() {
        return accountsList;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountUserId() {
        return accountUserId;
    }

    public enum accountType {
        Current,
        Saving,
    }

    @Override
    public String toString() {

        return "Accounts{" +
                "Id='" + getAccountId() + '\'' +
                ", Balance='" +getAccountBalance() + '\'' +
                ", UserId='" + getAccountUserId() + '\'' +
                ", AccountType='" + getAccType() + '\'' +
                '}';
    }


}

