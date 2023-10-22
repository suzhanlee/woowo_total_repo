package baseball;

public class test {

    public static final String INPUT = "input = ";

    public static void main(String[] args) {
        NumberInputter inputer = new NumberInputter(new DefaultConsole(), new NumberToBallConverter());
        for (int i = 0; i < 3; i++) {

            Ball ball = inputer.input();
            System.out.println(INPUT + ball);
        }
    }
}
