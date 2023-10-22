package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomBallGeneratorTest {


    @RepeatedTest(100)
    @DisplayName("서로 다른 3개의 숫자로 구성된 랜덤 숫자를 만들 수 있습니다.")
    void create() {
        // given
        RandomBallGenerator generator = new RandomBallGenerator();

        // when
        Ball result = generator.create();

        // then
        assertThat(result.getNumbers().size()).isEqualTo(3);
        assertThat(result.getNumbers().get(0)).isLessThanOrEqualTo(9);
        assertThat(result.getNumbers().get(0)).isGreaterThanOrEqualTo(1);
    }
}
