package util;

public class InputValidator {

    // Username: alphanumeric, max 50
    public static boolean isValidUsername(String username) {
        return username != null &&
                username.matches("^[a-zA-Z0-9]{1,50}$");
    }

    // Password: alphanumeric, 8–50 chars
    public static boolean isValidPassword(String password) {
        return password != null &&
                password.matches("^[a-zA-Z0-9]{8,50}$");
    }
}
