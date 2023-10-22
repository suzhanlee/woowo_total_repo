package baseball;

public class GameJudge {

    private final Ball answerBall;
    private static final String NOTHING = "낫싱";

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
