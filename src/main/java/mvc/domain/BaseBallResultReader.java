package mvc.domain;

public class BaseBallResultReader {

    private int ballCnt;
    private int strikeCnt;

    private static final String SPACE = " ";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";

    public BaseBallResultReader(int ballCnt, int strikeCnt) {
        this.ballCnt = ballCnt;
        this.strikeCnt = strikeCnt;
    }

    public String read() {
        if (strikeCnt == 3) {
            return strikeCnt + STRIKE;
        }

        StringBuilder resultStorage = new StringBuilder();

        countStrikeCnt(resultStorage);
        countBallCnt(resultStorage);

        return resultStorage.toString();
    }

    private void countBallCnt(StringBuilder resultStorage) {
        if (strikeCnt >= 1) {
            if (ballCnt >= 1) {
                resultStorage.append(SPACE);
            }
            resultStorage.append(strikeCnt).append(STRIKE);
        }
    }

    private void countStrikeCnt(StringBuilder resultStorage) {
        if (ballCnt >= 1) {
            resultStorage.append(ballCnt).append(BALL);
        }
    }
}
