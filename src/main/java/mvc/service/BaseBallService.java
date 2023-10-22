package mvc.service;

import mvc.domain.AnswerBallGenerator;
import mvc.domain.Ball;
import mvc.domain.GameJudge;

public class BaseBallService {

    public Ball createAnswerBall() {
        AnswerBallGenerator generator = new AnswerBallGenerator(new DefaultRandomService());
        return generator.generate();
    }

    public String makeGameResult(Ball answerBall, Ball tryBall) {
        GameJudge gameJudge = new GameJudge(answerBall);
        return gameJudge.judge(tryBall);
    }

}
