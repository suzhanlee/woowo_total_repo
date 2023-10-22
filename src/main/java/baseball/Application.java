package baseball;

public class Application {

    private static final String GAME_START_MENT = "숫자 야구 게임을 시작합니다.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(GAME_START_MENT);

        BaseBallGame baseBallGame;

        do {
            ConsoleService consoleService = new DefaultConsole();
            baseBallGame = new BaseBallGame(consoleService,
                new RandomBallGenerator(), new NumberInputter(consoleService, new NumberToBallConverter()));
            baseBallGame.startGame();
        } while (baseBallGame.chooseReGame());
    }
}
