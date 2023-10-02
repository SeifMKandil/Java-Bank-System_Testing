package exp.example;

public class NotValidEmailException extends Exception{
    public NotValidEmailException() {
        super("The email address is not valid.");
    }

    public NotValidEmailException(String message) {
        super(message);
    }

    public static void validateEmail(String email) throws NotValidEmailException {
        if (!isValidEmail(email)) {
            throw new NotValidEmailException("Invalid email address: " + email);
        }
    }

    private static boolean isValidEmail(String email) {
        // Your email validation logic here
        // This is a simplified example
        return email != null && email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
    }

}
