package mvc.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberToBallConverterTest {

    @Test
    @DisplayName("3자리 숫자를 Ball 로 변환할 수 있습니다")
    void convertToBall() {
        // given
        int tryNumber = 123;
        NumberToBallConverter converter = new NumberToBallConverter();

        // when
        Ball ball = converter.convert(tryNumber);

        // then
        assertThat(ball).isEqualTo(new Ball(List.of(1, 2, 3)));
    }

}
