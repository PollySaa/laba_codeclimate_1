package games;

import games.engine.GameLogic;
import java.util.Random;

public class LcmGame implements GameLogic {

    private final Random random = new Random();

    @Override
    public String generateQuestion() {
        int num1 = random.nextInt(20) + 1;
        int num2 = random.nextInt(20) + 1;
        int num3 = random.nextInt(20) + 1;
        return num1 + " " + num2 + " " + num3;
    }

    @Override
    public String getCorrectAnswer(String question) {
        String[] numbers = question.split(" ");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        int num3 = Integer.parseInt(numbers[2]);
        int lcm = calculateLcm(num1, num2, num3);
        return Integer.toString(lcm);
    }

    private int calculateLcm(int firstNumber, int secondNumber, int thirdNumber) {
        return calculateLcm(calculateLcm(firstNumber, secondNumber), thirdNumber);
    }

    private int calculateLcm(int firstNumber, int secondNumber) {
        return firstNumber * (secondNumber / calculateGcd(firstNumber, secondNumber));
    }

    private int calculateGcd(int firstNumber, int secondNumber) {
        while (secondNumber != 0) {
            int temp = secondNumber;
            secondNumber = firstNumber % secondNumber;
            firstNumber = temp;
        }
        return firstNumber;
    }
}