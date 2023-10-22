package baseball;

import static baseball.BaseBallConst.THREE_STRIKE;

public class BaseBallGame {
    private static final String CORRECT_ANSWER_MENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String REGAME_MENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final ConsoleService consoleService;
    private final RandomBallGenerator randomBallGenerator;
    private final NumberInputter numberInputter;

    public BaseBallGame(ConsoleService consoleService, RandomBallGenerator randomBallGenerator,
        NumberInputter numberInputter) {
        this.consoleService = consoleService;
        this.randomBallGenerator = randomBallGenerator;
        this.numberInputter = numberInputter;
    }

    public void startGame() {
        Ball answerBall = randomBallGenerator.create();
        GameJudge gameJudge = new GameJudge(answerBall);

        while (true) {
            Ball tryBall = numberInputter.input();
            String judgeResult = gameJudge.judge(tryBall);

            printJudgeResult(judgeResult);

            if (judgeResult.equals(THREE_STRIKE)) {
                printMent(CORRECT_ANSWER_MENT);
                break;
            }
        }
        printMent(REGAME_MENT);
    }

    public boolean chooseReGame() {
        int number = new ReGameInputer(consoleService).chooseReGame();
        if (number == 2) {
            consoleService.close();
            return false;
        }
        return true;
    }

    private void printJudgeResult(String judgeResult) {
        System.out.println(judgeResult);
    }

    private void printMent(String ment) {
        System.out.println(ment);
    }
}
