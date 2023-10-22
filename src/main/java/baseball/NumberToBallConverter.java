package baseball;

import java.util.ArrayList;
import java.util.List;

public class NumberToBallConverter {

    public Ball convert(int number) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 2; i >= 0; i--) {
            int digit = (int) Math.pow(10, i);
            numbers.add(number / digit);
            number = number % digit;
        }

        return new Ball(numbers);
    }
}
