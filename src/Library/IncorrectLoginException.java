package Library;

import java.util.InputMismatchException;

public class IncorrectLoginException extends InputMismatchException {

    public IncorrectLoginException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "incorrect login, please try again:";
    }
}
