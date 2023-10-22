package mvc.validator;

public class OutputValidator {

    public void valid(String value) {
        int number = isNotInteger(value);
        isNotOneOrTwo(number);
    }

    private int isNotInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void isNotOneOrTwo(int number) {
        if (number != 1 && number != 2) {
            throw new IllegalArgumentException();
        }
    }
}
