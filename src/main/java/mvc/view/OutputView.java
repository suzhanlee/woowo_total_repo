package mvc.view;

import camp.nextstep.edu.missionutils.Console;
import mvc.service.ConsoleService;
import mvc.validator.OutputValidator;

public class OutputView {

    private final OutputValidator validator;
    private final ConsoleService consoleService;

    public OutputView(OutputValidator validator, ConsoleService consoleService) {
        this.validator = validator;
        this.consoleService = consoleService;
    }

    public boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(consoleService.readLine()) == 1;
    }
}
