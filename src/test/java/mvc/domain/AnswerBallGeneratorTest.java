package mvc.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import mvc.service.MockRandomService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnswerBallGeneratorTest {

    @Test
    @DisplayName("정답 볼을 생성할 수 있다.")
    void generateRandom3Digit() {
        // given
        AnswerBallGenerator generator = new AnswerBallGenerator(new MockRandomService(4));
        // when
        Ball ball = generator.generate();
        // then
        assertThat(ball).isEqualTo(new Ball(List.of(4, 5, 6)));
    }
}
