import java.util.Random;
import java.util.Scanner;

public class LcmGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!!!");
        System.out.println("Find the smallest common multiple of given numbers.");

        int score = 0;
        while (score < 3) {
            int num1 = random.nextInt(20) + 1;
            int num2 = random.nextInt(20) + 1;
            int num3 = random.nextInt(20) + 1;

            int lcm = calculateLcm(num1, num2, num3);

            System.out.println("Question: " + num1 + " " + num2 + " " + num3);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            scanner.nextLine();

            if (userAnswer == lcm) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + lcm + "'.");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }

        if (score == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    private static int calculateLcm(int firstNumber, int secondNumber, int thirdNumber) {
        return calculateLcm(calculateLcm(firstNumber, secondNumber), thirdNumber);
    }

    private static int calculateLcm(int firstNumber, int secondNumber) {
        return firstNumber * (secondNumber / calculateGcd(firstNumber, secondNumber));
    }

    private static int calculateGcd(int firstNumber, int secondNumber) {
        while (secondNumber != 0) {
            int temp = secondNumber;
            secondNumber = firstNumber % secondNumber;
            firstNumber = temp;
        }
        return firstNumber;
    }
}