package mvc.domain;

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

        while (ballSizeIsNotOver(numbers)) {
            addNumberToBallIfNotDuplicate(numbers);
        }

        return new Ball(numbers);
    }

    private boolean ballSizeIsNotOver(List<Integer> numbers) {
        return numbers.size() < 3;
    }

    private void addNumberToBallIfNotDuplicate(List<Integer> numbers) {
        int number = randomService.pickNumberInRange(1, 9);
        if (isNotDuplicate(numbers, number)) {
            numbers.add(number);
        }
    }

    private boolean isNotDuplicate(List<Integer> numbers, int number) {
        return !numbers.contains(number);
    }
}
