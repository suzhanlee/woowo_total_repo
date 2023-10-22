package mvc.view;

import camp.nextstep.edu.missionutils.Console;
import mvc.domain.Ball;
import mvc.domain.NumberToBallConverter;
import mvc.service.ConsoleService;
import mvc.validator.InputValidator;

public class InputView {

    private final NumberToBallConverter converter;
    private final InputValidator validator;
    private final ConsoleService consoleService;

    public InputView(NumberToBallConverter numberToBallConverter, InputValidator validator,
        ConsoleService consoleService) {
        this.converter = numberToBallConverter;
        this.validator = validator;
        this.consoleService = consoleService;
    }

    public Ball createTryBall() {
        String inputString = consoleService.readLine();
        validator.valid(inputString);
        int inputValue = Integer.parseInt(inputString);
        System.out.println("숫자를 입력해주세요 : " + inputValue);
        return converter.convert(inputValue);
    }
}
