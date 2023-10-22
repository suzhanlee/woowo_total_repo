package baseball;

import static mvc.constant.BaseBallConst.NOTHING;
import static mvc.constant.BaseBallConst.ONE_BALL;
import static mvc.constant.BaseBallConst.ONE_BALL_ONE_STRIKE;
import static mvc.constant.BaseBallConst.ONE_STRIKE;
import static mvc.constant.BaseBallConst.THREE_STRIKE;
import static mvc.constant.BaseBallConst.TWO_BALL;
import static mvc.constant.BaseBallConst.TWO_BALL_ONE_STRIKE;
import static mvc.constant.BaseBallConst.TWO_STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameJudgeTest {

    GameJudge gameJudge;

    @BeforeEach
    void setUp() {
        Ball answerBall = new Ball(List.of(1, 2, 3));
        gameJudge = new GameJudge(answerBall);
    }

    @Test
    @DisplayName("3 스트라이크를 판단할 수 있습니다.")
    void threeStrike() {
        // when
        String result = gameJudge.judge(new Ball(List.of(1, 2, 3)));

        // then
        assertThat(result).isEqualTo(THREE_STRIKE);
    }

    @Test
    @DisplayName("낫싱을 판단할 수 있다.")
    void nothing() {
        // when
        String result = gameJudge.judge(new Ball(List.of(4, 5, 6)));

        // then
        assertThat(result).isEqualTo(NOTHING);
    }

    @Test
    @DisplayName("2스트라이크를 판단할 수 있다.")
    void twoStrike() {
        // when
        String result = gameJudge.judge(new Ball(List.of(1, 2, 6)));

        // then
        assertThat(result).isEqualTo(TWO_STRIKE);
    }

    @Test
    @DisplayName("1스트라이크를 판단할 수 있다.")
    void oneStrike() {
        // when
        String result = gameJudge.judge(new Ball(List.of(1, 8, 6)));

        // then
        assertThat(result).isEqualTo(ONE_STRIKE);
    }

    @Test
    @DisplayName("1스트라이크 2볼을 판단할 수 있다.")
    void twoBallOneStrike() {
        // when
        String result = gameJudge.judge(new Ball(List.of(1, 3, 2)));

        // then
        assertThat(result).isEqualTo(TWO_BALL_ONE_STRIKE);
    }

    @Test
    @DisplayName("1스트라이크 1볼을 판단할 수 있다.")
    void oneBallOneStrike() {
        // when
        String result = gameJudge.judge(new Ball(List.of(1, 8, 2)));

        // then
        assertThat(result).isEqualTo(ONE_BALL_ONE_STRIKE);
    }

    @Test
    @DisplayName("2볼을 판단할 수 있다.")
    void twoBall() {
        // when
        String result = gameJudge.judge(new Ball(List.of(3, 4, 1)));

        // then
        assertThat(result).isEqualTo(TWO_BALL);
    }

    @Test
    @DisplayName("1볼을 판단할 수 있다.")
    void oneBall() {
        // when
        String result = gameJudge.judge(new Ball(List.of(2, 8, 6)));

        // then
        assertThat(result).isEqualTo(ONE_BALL);
    }

}
