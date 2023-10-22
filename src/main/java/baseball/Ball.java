package baseball;

import java.util.List;
import java.util.Objects;

public class Ball {

    private final List<Integer> numbers;

    public Ball(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean hasNoRelationWith(Ball tryBall) {
        for (Integer answer : numbers) {
            if (tryBall.numbers.contains(answer)) {
                return false;
            }
        }
        return true;
    }

    public String compareWith(Ball tryBall) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i = 0; i < 3; i++) {
            Integer answerNumber = this.numbers.get(i);
            if (answerNumber.equals(tryBall.numbers.get(i))) {
                strikeCnt++;
            } else {
                if (tryBall.numbers.contains(answerNumber)) {
                    ballCnt++;
                }
            }
        }

        BaseBallResultReader reader = new BaseBallResultReader(ballCnt, strikeCnt);
        return reader.read();
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
