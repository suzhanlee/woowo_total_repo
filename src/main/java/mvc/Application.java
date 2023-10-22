package mvc;

import mvc.controller.BaseBallController;
import mvc.controller.FrontController;
import mvc.domain.AnswerBallGenerator;
import mvc.domain.NumberToBallConverter;
import mvc.service.BaseBallService;
import mvc.service.ConsoleService;
import mvc.service.DefaultConsoleService;
import mvc.service.DefaultRandomService;
import mvc.validator.InputValidator;
import mvc.validator.OutputValidator;
import mvc.view.InputView;
import mvc.view.OutputView;

public class Application {

    public static void main(String[] args) {
        ConsoleService consoleService = new DefaultConsoleService();
        BaseBallService baseBallService = new BaseBallService(new AnswerBallGenerator(new DefaultRandomService()));
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
