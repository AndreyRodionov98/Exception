

public class Data {
    public static final String VALID_CHARACTERS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM_";

    public Data() {
    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;


    }

    public static void check(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (!validate(login)){
            throw new WrongLoginException("Логин введен не корректно!");
        }
        if (!validate(password)){
            throw new WrongPasswordException("пароль введен не корректно!");
        }
        if (!validate(confirmPassword)){
            throw new WrongPasswordException("пароль введен не корректно!");
        }
    }

    public static boolean validate(String p) {
        if (p.length() >= 20) {
            return false;
        }
        for (int i = 0; i < p.length(); i++) {
            if (!VALID_CHARACTERS.contains(String.valueOf(p.charAt(i)))) {
                return false;
            }

        }
        return true;
    }


}


