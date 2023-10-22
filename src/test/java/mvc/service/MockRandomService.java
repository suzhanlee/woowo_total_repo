package mvc.service;

public class MockRandomService implements RandomService {

    private int nowNumber;

    public MockRandomService(int nowNumber) {
        this.nowNumber = nowNumber;
    }

    @Override
    public int pickNumberInRange(final int startInclusive, final int endInclusive) {
        int returnNumber = this.nowNumber;
        if (startInclusive > nowNumber || nowNumber > endInclusive) {
            throw new IllegalArgumentException("랜덤 값이 1 ~ 9 사이가 아닙니다.");
        }

        nowNumber += 1;
        return returnNumber;
    }
}
