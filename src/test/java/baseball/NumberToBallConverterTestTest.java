package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberToBallConverterTestTest {

    @Test
    @DisplayName("세 자리 숫자를 Ball로 바꿀 수 있다.")
    void convert() {
        // given
        int number = 123;
        NumberToBallConverter converter = new NumberToBallConverter();

        // when
        Ball ball = converter.convert(number);

        // then
        assertThat(ball).isEqualTo(new Ball(List.of(1, 2, 3)));
    }

}
