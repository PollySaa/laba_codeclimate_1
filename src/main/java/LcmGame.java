import java.util.Random;
import java.util.Scanner;

public class LcmGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        greetUser();
        String name = askForName(scanner);
        greetUserByName(name);
        explainRules();

        playGame(scanner, random, name);
    }

    private static void greetUser() {
        System.out.println("Welcome to the Brain Games!");
    }

    private static String askForName(Scanner scanner) {
        System.out.print("May I have your name? ");
        return scanner.nextLine();
    }

    private static void greetUserByName(String name) {
        System.out.println("Hello, " + name + "!!!");
    }

    private static void explainRules() {
        System.out.println("Find the smallest common multiple of given numbers.");
    }

    private static void playGame(Scanner scanner, Random random, String name) {
        int score = 0;

        while (score < 3) {
            int num1 = random.nextInt(20) + 1;
            int num2 = random.nextInt(20) + 1;
            int num3 = random.nextInt(20) + 1;

            displayQuestion(num1, num2, num3);
            int userAnswer = getUserAnswer(scanner);

            final int lcm = calculateLcm(num1, num2, num3);

            if (checkAnswer(userAnswer, lcm)) {
                System.out.println("Correct!");
                score++;
            } else {
                handleWrongAnswer(userAnswer, lcm, name);
                break;
            }
        }

        if (score == 3) {
            congratulateUser(name);
        }
    }

    private static void displayQuestion(int num1, int num2, int num3) {
        System.out.println("Question: " + num1 + " " + num2 + " " + num3);
    }

    private static int getUserAnswer(Scanner scanner) {
        System.out.print("Your answer: ");
        int userAnswer = scanner.nextInt();
        scanner.nextLine();
        return userAnswer;
    }

    private static boolean checkAnswer(int userAnswer, int correctAnswer) {
        return userAnswer == correctAnswer;
    }

    private static void handleWrongAnswer(int userAnswer, int correctAnswer, String name) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + name + "!");
    }

    private static void congratulateUser(String name) {
        System.out.println("Congratulations, " + name + "!");
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