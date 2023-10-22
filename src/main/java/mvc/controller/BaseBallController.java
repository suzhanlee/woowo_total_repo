package mvc.controller;

import mvc.constant.BaseBallConst;
import mvc.domain.Ball;
import mvc.domain.NumberToBallConverter;
import mvc.service.BaseBallService;
import mvc.service.ConsoleService;
import mvc.validator.InputValidator;
import mvc.view.InputView;

public class BaseBallController {

    private final InputView inputView;
    private final BaseBallService baseBallService;

    public BaseBallController(InputView inputView, BaseBallService baseBallService) {
        this.inputView = inputView;
        this.baseBallService = baseBallService;
    }

    public void startGame(Ball answerBall) {
        String gameResult;

        do {
            Ball tryBall = inputView.createTryBall();
            gameResult = baseBallService.makeGameResult(answerBall, tryBall);
            System.out.println(gameResult);
        } while (!gameResult.equals(BaseBallConst.THREE_STRIKE));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
