package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

    /**
     * Static method returns true for successful login, false otherwise.
     * @param username
     * @param password
     * @return
     */
    public static boolean login(String username, String password, String dob) {
        // Match a fixed username and password.
        if (username.equals("testuser") && password.equals("testpass") && dob.equals("2000-06-15")) {
            return true;
        }

        return false;
    }


}
