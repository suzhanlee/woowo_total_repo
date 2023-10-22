package mvc.domain;

import static mvc.constant.BaseBallConst.NOTHING;

public class GameJudge {

    private final Ball answerBall;

    public GameJudge(Ball answerBall) {
        this.answerBall = answerBall;
    }

    public String judge(Ball tryBall) {
        if (answerBall.hasNoRelationWith(tryBall)) {
            return NOTHING;
        }

        return answerBall.compareWith(tryBall);
    }

}
