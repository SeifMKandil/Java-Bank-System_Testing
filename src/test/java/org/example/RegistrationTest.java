package org.example;

import exp.example.NotValidEmailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegistrationTest {
    private Registration register;
    private Registration registerMock;
    @BeforeEach
    public void setUp() {
        registerMock = mock(Registration.class);
        register = new Registration();
    }

    @Test
    @DisplayName("Test Signup with existing email")
    public void SignUpWithExistingEmail() throws NotValidEmailException{
        Registration register = new Registration();
        User existingUser = new User("Seiko", "Seiko@gmail.com", "qweasd");
        register.signUp(existingUser.getFullName(), existingUser.getEmail(), existingUser.getPassword());

        User newUser = new User("NewUser", "Seiko@gmail.com", "password123");
        boolean signUpResult = register.signUp(newUser.getFullName(), newUser.getEmail(), newUser.getPassword());
        assertFalse(signUpResult);
    }

    @Test
    @DisplayName("Test Signup with valid credentials")
    void testSignUp() throws NotValidEmailException{
        register.signUp("Seiko" , "Seiko@gmail.com" , "qweasd");
        User user= new User("Seiko" , "Seiko@gmail.com" , "qweasd");
        assertTrue( register.getRegistredUsers().contains(user));
    }

    @Test
    @DisplayName("Test Signup with invalid email format")
    void testSignUpWithInvalidEmailFormat() throws NotValidEmailException {
        Registration register = new Registration();

        // Use assertThrows to expect the NotValidEmailException
        NotValidEmailException exception = assertThrows(NotValidEmailException.class, () -> {
            register.signUp("Seiko", "Seiko", "qweasd");
        });

        assertEquals("Invalid email address: Seiko", exception.getMessage());
    }


    //*******************************Login Section************************************
    @Test
    @DisplayName("Login with Valid Credentials")
    public void LoginTest(){
        ArrayList<User> registredUsersMock = new ArrayList<>();
        User user = new User("Seiko", "Seiko@gmail.com", "qweasd");
        registredUsersMock.add(user);
        when(registerMock.login("Seiko@gmail.com" ,"qweasd" )).thenReturn(registredUsersMock.contains(new User("Seiko", "Seiko@gmail.com", "qweasd")));

        assertTrue(registerMock.login("Seiko@gmail.com" ,"qweasd"));

}

    @Test
    @DisplayName("Login with Invalid Email and Valid Password")
    public void LoginInValidEmail(){
        String name="Seiko";
        String email = "Seiko2@gmail.com";
        String password = "qweasd";
        ArrayList<User> registredUsersMock = new ArrayList<>();
        User user = new User("Seiko", "Seiko@gmail.com", "qweasd");
        registredUsersMock.add(user);
        when(registerMock.login(email,password )).thenReturn(registredUsersMock.contains(new User(name, email,password)));

        assertFalse(registerMock.login(email ,password));

    }

    @Test
    @DisplayName("Login with Valid Email and InValid Password")
    public void LoginInValidPassword(){
        String name="Seiko";
        String email = "Seiko@gmail.com";
        String password = "qweasdd";
        ArrayList<User> registredUsersMock = new ArrayList<>();
        User user = new User("Seiko", "Seiko@gmail.com", "qweasd");
        registredUsersMock.add(user);
        when(registerMock.login(email,password )).thenReturn(registredUsersMock.contains(new User(name, email,password)));

        assertFalse(registerMock.login(email ,password));

    }

    @Test
    @DisplayName("Login with InValid Email and InValid Password")
    public void LoginInValid(){
        String name="Seiko";
        String email = "Seiko2@gmail.com";
        String password = "qweasdd";
        ArrayList<User> registredUsersMock = new ArrayList<>();
        User user = new User("Seiko", "Seiko@gmail.com", "qweasd");
        registredUsersMock.add(user);
        when(registerMock.login(email,password )).thenReturn(registredUsersMock.contains(new User(name, email,password)));

        assertFalse(registerMock.login(email ,password));

    }

}