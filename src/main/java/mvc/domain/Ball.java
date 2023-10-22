package mvc.domain;

import java.util.List;
import java.util.Objects;

public class Ball {

    private final List<Integer> numbers;

    public Ball(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean hasNoRelationWith(Ball tryBall) {
        return numbers.stream()
            .noneMatch(answerNumber -> tryBallHasAnswerNumber(tryBall, answerNumber));
    }

    public String compareWith(Ball tryBall) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int ballNumberPlace = 0; ballNumberPlace < 3; ballNumberPlace++) {
            if (isStrike(tryBall, ballNumberPlace)) {
                strikeCnt++;
                continue;
            }

            if (tryBallHasAnswerNumber(tryBall, this.numbers.get(ballNumberPlace))) {
                ballCnt++;
            }
        }

        BaseBallResultReader reader = new BaseBallResultReader(ballCnt, strikeCnt);
        return reader.read();
    }



    private boolean isStrike(Ball tryBall, int ballNumberPlace) {
        return this.numbers.get(ballNumberPlace).equals(tryBall.numbers.get(ballNumberPlace));
    }

    private boolean tryBallHasAnswerNumber(Ball tryBall, Integer answerNumber) {
        return tryBall.numbers.contains(answerNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return Objects.equals(numbers, ball.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
