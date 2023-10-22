package mvc.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import mvc.domain.Ball;
import mvc.domain.NumberToBallConverter;
import mvc.service.MockConsoleService;
import mvc.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    @DisplayName("사용자는 원하는 3자리 수를 입력할 수 있다.")
    void input() {
        // given
        InputView inputView = new InputView(new NumberToBallConverter(), new InputValidator(),
            new MockConsoleService("123"));
        // when
        Ball ball = inputView.createTryBall();
        // then
        assertThat(ball).isEqualTo(new Ball(List.of(1, 2, 3)));
    }

}
