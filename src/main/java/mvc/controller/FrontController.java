package mvc.controller;

import mvc.domain.Ball;
import mvc.service.BaseBallService;
import mvc.service.ConsoleService;
import mvc.validator.OutputValidator;
import mvc.view.OutputView;

public class FrontController {

    private final BaseBallController baseBallController;
    private final BaseBallService baseBallService;
    private final OutputView outputView;

    public FrontController(BaseBallController baseBallController, BaseBallService baseBallService, OutputView outputView) {
        this.baseBallController = baseBallController;
        this.baseBallService = baseBallService;
        this.outputView = outputView;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            Ball answerBall = baseBallService.createAnswerBall();
            baseBallController.startGame(answerBall);

        } while (outputView.isRestart());
        System.out.println("게임 종료");
    }
}
