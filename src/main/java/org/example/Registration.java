package org.example;

import exp.example.NotValidEmailException;

import java.util.ArrayList;

public class Registration extends NotValidEmailException {
    ArrayList<User> registredUsers=new ArrayList<>();
    User user =  new User();

    private User loggedInUser;

    public boolean signUp(String Name, String Email, String Password) throws NotValidEmailException {
        try {
            validateEmail(Email);

            // Check if the email already exists in the registered users list
            boolean emailExists = false;
            for (User user : registredUsers) {
                if (user.getEmail().equals(Email)) {
                    emailExists = true;
                    break;
                }
            }

            if (emailExists) {
                System.out.println("Email Already Exists. Sign-In?");
                return false;

            } else {
                registredUsers.add(new User(Name, Email, Password));
                System.out.println("Registration successful!");
                return true;
            }
        } catch (NotValidEmailException e) {
            System.err.println("Email is not valid: " + e.getMessage());
            throw e;
        }
    }


    public boolean login(String Email, String Password) {
        for (User user : registredUsers) {
            if (user.getEmail().equals(Email) && user.getPassword().equals(Password)) {
                System.out.println("Welcome: "+user.getFullName() +"!!");
                loggedInUser = user;
               return true;
            }
        }

           return false;

    }


    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setRegistredUsers(ArrayList<User> registredUsers) {
        this.registredUsers = registredUsers;
    }

    public ArrayList<User> getRegistredUsers() {

        return registredUsers;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + user.getFullName() + '\'' +
                ", email='" +user.getEmail() + '\'' +
                ", password='" + user.getPassword() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!user.getFullName().equals(user.getFullName())) return false;
        if (!user.getEmail().equals(user.getEmail())) return false;
        return user.getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        int result = user.getFullName().hashCode();
        result = 31 * result + user.getEmail().hashCode();
        result = 31 * result + user.getPassword().hashCode();
        return result;
    }

}
