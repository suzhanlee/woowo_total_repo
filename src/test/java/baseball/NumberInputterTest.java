package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberInputterTest {

    NumberToBallConverter numberToBallConverter;

    @BeforeEach
    void setUp() {
        numberToBallConverter = new NumberToBallConverter();
    }

    @Test
    @DisplayName("사용자는 값을 입력할 수 있다.")
    void input() {
        // given
        String testValue = "123";
        NumberInputter numberInputter = new NumberInputter(new MockConsole(testValue),
            numberToBallConverter);

        // when
        Ball ball = numberInputter.input();

        // then
        for (Integer result : ball.getNumbers()) {
            assertThat(result).isGreaterThanOrEqualTo(1);
            assertThat(result).isLessThanOrEqualTo(9);
        }
    }

    @Test
    @DisplayName("사용자가 세자리 이상의 수를 입력하면 IllegalArgumentException을 던진다.")
    void inputErrorWithGreaterThan3Digit() {
        // given
        String testValue = "1234";
        NumberInputter numberInputter = new NumberInputter(new MockConsole(testValue),
            numberToBallConverter);

        // when //then
        assertThatThrownBy(numberInputter::input)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 세자리 이하의 수를 입력하면 IllegalArgumentException을 던진다.")
    void inputErrorWithLessThan3Digit() {
        // given
        String testValue = "12";
        NumberInputter numberInputter = new NumberInputter(new MockConsole(testValue),
            numberToBallConverter);

        // when //then
        assertThatThrownBy(numberInputter::input)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 숫자가 아닌 값을 입력하면 IllegalArgumentException을 던진다.")
    void inputErrorWithNotNumber() {
        // given
        String testValue = "숫자가 아니다!";
        NumberInputter numberInputter = new NumberInputter(new MockConsole(testValue),
            numberToBallConverter);

        // when //then
        assertThatThrownBy(numberInputter::input)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}
