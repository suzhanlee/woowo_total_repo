package mvc.view;

import static org.assertj.core.api.Assertions.assertThat;

import mvc.service.MockConsoleService;
import mvc.validator.OutputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    @Test
    @DisplayName("1번을 누르면 게임을 재시작하기 위해 true 반환.")
    void restart() {
        // given
        OutputView outputView = new OutputView(new OutputValidator(),new MockConsoleService("1"));

        // when
        boolean restart = outputView.isRestart();

        // then
        assertThat(restart).isEqualTo(true);
    }

    @Test
    @DisplayName("2번을 누르면 게임을 종료하기 위해 false 반환.")
    void exit() {
        // given
        OutputView outputView = new OutputView(new OutputValidator(),new MockConsoleService("2"));

        // when
        boolean restart = outputView.isRestart();

        // then
        assertThat(restart).isEqualTo(false);
    }

}
