package mvc.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OutputValidatorTest {

    @ParameterizedTest
    @DisplayName("1 또는 2만 입력할 수 있다.")
    @ValueSource(strings = {"1", "2"})
    void validCorrect(String given) {
        // given
        OutputValidator validator = new OutputValidator();
        // when // then
        Assertions.assertThatCode(() -> validator.valid(given))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("1 과 2 외의 값은 예외를 던진다.")
    @ValueSource(strings = {"12", "3", "가", "%$", "0"})
    void validError(String given) {
        // given
        OutputValidator validator = new OutputValidator();
        // when // then
        Assertions.assertThatThrownBy(() -> validator.valid(given))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
