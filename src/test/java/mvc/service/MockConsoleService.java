package mvc.service;

import camp.nextstep.edu.missionutils.Console;

public class MockConsoleService implements ConsoleService {
    private String value;

    public MockConsoleService(String value) {
        this.value = value;
    }

    @Override
    public String readLine() {
        return value;
    }

    @Override
    public void close() {
        Console.close();
    }
}
