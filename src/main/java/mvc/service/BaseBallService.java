package mvc.service;

import mvc.domain.AnswerBallGenerator;
import mvc.domain.Ball;
import mvc.domain.GameJudge;

public class BaseBallService {

    private final AnswerBallGenerator answerBallGenerator;

    public BaseBallService(AnswerBallGenerator answerBallGenerator) {
        this.answerBallGenerator = answerBallGenerator;
    }

    public Ball createAnswerBall() {
        return answerBallGenerator.generate();
    }

    public String createGameResultWith(Ball answerBall, Ball tryBall) {
        GameJudge gameJudge = new GameJudge(answerBall);
        return gameJudge.judge(tryBall);
    }

}
