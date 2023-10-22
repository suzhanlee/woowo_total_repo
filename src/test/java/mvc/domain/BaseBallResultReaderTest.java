package mvc.domain;

import static mvc.constant.BaseBallConst.ONE_BALL_ONE_STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallResultReaderTest {

    @Test
    @DisplayName("볼 수와 스트라이크 수를 포멧팅해 문자열을 반환한다.")
    void read() {
        // given
        BaseBallResultReader reader = new BaseBallResultReader(1, 1);

        // when
        String result = reader.read();

        // then
        assertThat(result).isEqualTo(ONE_BALL_ONE_STRIKE);
    }

}