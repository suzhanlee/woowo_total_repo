package mvc.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @ParameterizedTest
    @DisplayName("사용자가 입력한 값이 유효한지 확인할 수 있다.")
    @ValueSource(strings = {"123", "378", "981"})
    void validCorrect(String given) {
        // given
        InputValidator validator = new InputValidator();
        // when // then
        assertThatCode(() -> validator.valid(given))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("사용자가 입력한 값이 유효하지 않은지 확인할 수 있다.")
    @ValueSource(strings = {"1234", "3781", "98", "999", "가나다", "$#3"})
    void validError(String given) {
        // given
        InputValidator validator = new InputValidator();
        // when // then
        assertThatThrownBy(() -> validator.valid(given))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
