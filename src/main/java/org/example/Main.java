package org.example;

import exp.example.NotValidEmailException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NotValidEmailException {
            Registration register = new Registration();
            Account account = new Account(register);
            ArrayList<Account> accountsList = account.getAccountsList();

            Scanner input = new Scanner(System.in);

            while (true) {
                System.out.println("\u001B[34mWelcome to the banking system!\u001B[0m");
                System.out.println("\u001B[31my to login\nn to register\nE to exit\u001B[0m");

                String choice = input.next();

                if (choice.equalsIgnoreCase("E")) {
                    System.out.println("Exiting the program.");
                    break;
                }

                if (choice.equalsIgnoreCase("y")) {
                    System.out.println("Enter Login Email");
                    String loginEmail = input.next();

                    System.out.println("Enter Login Password");
                    String loginPassword = input.next();

                    boolean loggedIn = register.login(loginEmail, loginPassword);

                    if (loggedIn) {
                        System.out.println("Login successful!");

                        displayAccountMenu(account);

                    } else {
                        System.out.println("Login failed. Invalid credentials.");
                    }
                } else if (choice.equalsIgnoreCase("n")) {
                    System.out.println("Enter Name");
                    String name = input.next();

                    System.out.println("Enter Email");
                    String email = input.next();

                    System.out.println("Enter Password");
                    String password = input.next();

                    register.signUp(name, email, password);

                    System.out.println("Registration successful!");
                } else {
                    System.out.println("Invalid choice. Please enter 'y' for login, 'n' for sign-up, or 'E' to exit.");
                }
            }
        }

    private static void displayAccountMenu(Account account) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nAccount Menu:");
            System.out.println("1. Create a New Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Logout");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Account Type (Current/Saving):");
                    String accountType = input.next();
                    System.out.println("Enter Account ID:");
                    String accountId = input.next();
                    System.out.println("Enter Initial Balance:");
                    double initialBalance = input.nextDouble();
                    System.out.println("Enter Your Id:");
                    String userId = input.next();
                    account.newAccount(Account.accountType.valueOf(accountType), accountId, userId, initialBalance);
                    break;
                case 2:
                    System.out.println("Enter Account ID:");
                    String depositAccountId = input.next();
                    System.out.println("Enter Amount to Deposit:");
                    String userIdd = input.next();
                    System.out.println("Enter Amount to Deposit:");
                    double depositAmount = input.nextDouble();
                    account.Deposit(depositAccountId, depositAmount , userIdd);
                    break;
                case 3:
                    System.out.println("Enter AccountID:");
                    String withdrawAccountId = input.next();
                    System.out.println("Enter UserID:");
                    String withdrawUserId = input.next();
                    System.out.println("Enter Amount to Withdraw:");
                    double withdrawAmount = input.nextDouble();
                    account.Withdraw(withdrawAccountId, withdrawAmount,withdrawUserId);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        }
    }

