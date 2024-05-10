package web.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    public static boolean login(String username, String password, String dob) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient(false);
        df.parse(dob);

        // Match a fixed username and password.
        if (username.equals("testuser") && password.equals("testpass") && dob.equals("2000-06-15")) {
            return true;
        }

        return false;
    }


}
