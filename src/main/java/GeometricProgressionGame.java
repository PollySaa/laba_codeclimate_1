import java.util.Random;
import java.util.Scanner;

public class GeometricProgressionGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String name = askForName(scanner);
        greetUser(name);

        playGame(scanner, random, name);
    }

    private static String askForName(Scanner scanner) {
        System.out.print("May I have your name? ");
        return scanner.nextLine();
    }

    private static void greetUser(String name) {
        System.out.println("Hello, " + name + "!");
    }

    private static void playGame(Scanner scanner, Random random, String name) {
        System.out.println("What number is missing in the progression?");
        int score = 0;

        while (score < 3) {
            int progressionLength = random.nextInt(6) + 5;
            int hiddenIndex = random.nextInt(progressionLength);
            int firstTerm = random.nextInt(10) + 1;
            int commonRatio = random.nextInt(5) + 1;

            int[] progression = generateProgression(firstTerm, commonRatio, progressionLength);
            String[] progressionWithHidden = hideElement(progression, hiddenIndex);

            displayQuestion(progressionWithHidden);

            int userAnswer = getUserAnswer(scanner);

            if (checkAnswer(userAnswer, progression[hiddenIndex])) {
                System.out.println("Correct!");
                score++;
            } else {
                handleWrongAnswer(userAnswer, progression[hiddenIndex], name);
                break;
            }
        }

        if (score == 3) {
            congratulateUser(name);
        }
    }

    private static void displayQuestion(String[] progressionWithHidden) {
        System.out.print("Question: ");
        for (String element : progressionWithHidden) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static int getUserAnswer(Scanner scanner) {
        System.out.print("Your answer: ");
        int userAnswer = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        return userAnswer;
    }

    private static boolean checkAnswer(int userAnswer, int correctAnswer) {
        return userAnswer == correctAnswer;
    }

    private static void handleWrongAnswer(int userAnswer, int correctAnswer, String name) {
        String wrongAnswerMessage = String.format(
                "'%d' is wrong answer ;(. Correct answer was '%d'.",
                userAnswer, correctAnswer
        );
        System.out.println(wrongAnswerMessage);
        System.out.println("Let's try again, " + name + "!");
    }

    private static void congratulateUser(String name) {
        System.out.println("Congratulations, " + name + "!");
    }

    private static int[] generateProgression(int firstTerm, int commonRatio, int length) {
        int[] progression = new int[length];
        progression[0] = firstTerm;

        for (int i = 1; i < length; i++) {
            progression[i] = progression[i - 1] * commonRatio;
        }

        return progression;
    }

    private static String[] hideElement(int[] progression, int hiddenIndex) {
        String[] progressionWithHidden = new String[progression.length];

        for (int i = 0; i < progression.length; i++) {
            if (i == hiddenIndex) {
                progressionWithHidden[i] = "..";
            } else {
                progressionWithHidden[i] = Integer.toString(progression[i]);
            }
        }

        return progressionWithHidden;
    }
}