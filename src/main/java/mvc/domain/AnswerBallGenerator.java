package mvc.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import mvc.service.RandomService;

public class AnswerBallGenerator {

    private final RandomService randomService;

    public AnswerBallGenerator(RandomService randomService) {
        this.randomService = randomService;
    }

    public Ball generate() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            addNumberToBallIfNotDuplicate(numbers);
        }

        return new Ball(numbers);
    }

    private void addNumberToBallIfNotDuplicate(List<Integer> numbers) {
        int number = randomService.pickNumberInRange(1, 9);
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
