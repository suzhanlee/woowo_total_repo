package baseball;

public class NumberInputter {

    private static final String PLEASE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private final ConsoleService consoleService;
    private final NumberToBallConverter numberToBallConverter;

    public NumberInputter(ConsoleService consoleService, NumberToBallConverter numberToBallConverter) {
        this.consoleService = consoleService;
        this.numberToBallConverter = numberToBallConverter;
    }

    public Ball input() {
        int inputValue = readLine();
        if (inputValue >= 123 && inputValue <= 987) {
            System.out.println(PLEASE_INPUT_NUMBER + inputValue);
            return numberToBallConverter.convert(inputValue);
        }

        throw new IllegalArgumentException();
    }

    private int readLine() {
        try {
            return Integer.parseInt(consoleService.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
