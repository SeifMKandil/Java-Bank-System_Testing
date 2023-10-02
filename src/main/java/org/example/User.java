package org.example;

public class User {
    private String FullName;
    private String Email;
    private String Password;

    public User(){}
    public User(String fullName, String email, String password) {
        FullName = fullName;
        Email = email;
        Password = password;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + this.FullName + '\'' +
                ", email='" + this.Email + '\'' +
                ", password='" + this.Password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!FullName.equals(user.getFullName())) return false;
        if (!Email.equals(user.getEmail())) return false;
        return Password.equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        User user = new User();
        int result = user.getFullName().hashCode();
        result = 31 * result + user.getEmail().hashCode();
        result = 31 * result + user.getPassword().hashCode();
        return result;
    }
}

