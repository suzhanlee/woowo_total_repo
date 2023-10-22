package baseball;

public class ReGameInputer {

    private final ConsoleService consoleService;

    public ReGameInputer(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    public int chooseReGame() {
        try {
            return Integer.parseInt(consoleService.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
