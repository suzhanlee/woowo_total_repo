package mvc;

import mvc.controller.BaseBallController;
import mvc.controller.FrontController;
import mvc.domain.NumberToBallConverter;
import mvc.service.BaseBallService;
import mvc.service.ConsoleService;
import mvc.service.DefaultConsoleService;
import mvc.validator.InputValidator;
import mvc.validator.OutputValidator;
import mvc.view.InputView;
import mvc.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BaseBallService baseBallService = new BaseBallService();
        ConsoleService consoleService = new DefaultConsoleService();
        FrontController controller = new FrontController(
            new BaseBallController(
                new InputView(
                    new NumberToBallConverter(),
                    new InputValidator(),
                    consoleService
                ),
                baseBallService
            ),
            baseBallService,
            new OutputView(new OutputValidator(), consoleService));
        controller.startGame();
    }
}
