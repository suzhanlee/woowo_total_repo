package baseball;

public class MockConsole implements ConsoleService {

    private final String value;

    public MockConsole(String value) {
        this.value = value;
    }

    @Override
    public String readLine() {
        return value;
    }

    @Override
    public void close() {}
}
