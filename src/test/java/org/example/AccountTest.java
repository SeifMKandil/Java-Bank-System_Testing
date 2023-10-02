package org.example;

import exp.example.NotValidEmailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class AccountTest {
    private Registration registration;

    private Account account;
    @BeforeEach
    public void setUp() {
        registration = new Registration();
        account = new Account(registration);
    }
    @Test
    @DisplayName("Deposit with valid input data")
    public void DepositValid() throws NotValidEmailException {
        registration.signUp("Seiko" , "Seiko@gmail.com" , "qweasd");
        registration.login("Seiko@gmail.com","qweasd");
        account.newAccount(Account.accountType.Current, "1234", "12", 1000);
        assertTrue(account.Deposit("1234", 500, "12"));

    }
    @Test
    @DisplayName("Deposit with Invalid userId ")
    public void depositInvalidUserId() throws NotValidEmailException {
        registration.signUp("Seiko" , "Seiko@gmail.com" , "qweasd");
        registration.login("Seiko@gmail.com","qweasd");
        account.newAccount(Account.accountType.Current, "1234", "12", 1000);
        assertFalse(account.Deposit("1234", 500, "122"));

    }

    @Test
    @DisplayName("Deposit with Invalid accountId ")
    public void depositInvalidAccountId() throws NotValidEmailException {
        registration.signUp("Seiko" , "Seiko@gmail.com" , "qweasd");
        registration.login("Seiko@gmail.com","qweasd");
        account.newAccount(Account.accountType.Current, "1234", "12", 1000);
        assertFalse(account.Deposit("12345", 500, "12"));

    }

    @Test
    @DisplayName("Deposit without LoggingIn ")
    public void depositWithoutLoggingIn() throws NotValidEmailException {
        registration.signUp("Seiko" , "Seiko@gmail.com" , "qweasd");
        account.newAccount(Account.accountType.Current, "1234", "12", 1000);
        assertFalse(account.Deposit("1234", 500, "12"));
    }


    @Test
    @DisplayName("User Cannot withdraw amount > his balance.")
    public void invalidWithdraw() throws NotValidEmailException {
        registration.signUp("Seiko" , "Seiko@gmail.com" , "qweasd");
        account.newAccount(Account.accountType.Current, "1234", "12", 1000);
        assertFalse(account.Withdraw("1234", 2000, "12"));
    }


}
