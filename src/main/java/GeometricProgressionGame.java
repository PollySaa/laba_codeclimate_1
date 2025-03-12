import java.util.Random;
import java.util.Scanner;

public class GeometricProgressionGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        System.out.println("What number is missing in the progression?");
        int score = 0;

        while (score < 3) {
            int progressionLength = random.nextInt(6) + 5;
            int hiddenIndex = random.nextInt(progressionLength);
            int firstTerm = random.nextInt(10) + 1;
            int commonRatio = random.nextInt(5) + 1;

            int[] progression = generateProgression(firstTerm, commonRatio, progressionLength);
            String[] progressionWithHidden = hideElement(progression, hiddenIndex);

            System.out.print("Question: ");
            for (String element : progressionWithHidden) {
                System.out.print(element + " ");
            }
            System.out.println();

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            if (userAnswer == progression[hiddenIndex]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + progression[hiddenIndex] + "'.");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }

        if (score == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
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