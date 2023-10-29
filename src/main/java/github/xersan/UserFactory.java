package github.xersan;

import java.util.regex.Pattern;

final class UserFactory {

    static int createUser(String name, String email) {
        if (name.isBlank())
            return 1;

        if (!isValidEmail(email))
            return 2;

        new User(name, email);
        return 0;
    }

    private static boolean isValidEmail(String emailString) {
        return Pattern.matches("^(?>ics|iis|dai)\\d{3,5}@uom\\.edu\\.gr$", emailString.toLowerCase());
    }

}
