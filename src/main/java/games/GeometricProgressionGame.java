package games;

import games.engine.GameLogic;
import java.util.Random;

public class GeometricProgressionGame implements GameLogic {

    private final Random random = new Random();

    @Override
    public String generateQuestion() {
        int progressionLength = random.nextInt(6) + 5;
        int hiddenIndex = random.nextInt(progressionLength);
        int firstTerm = random.nextInt(10) + 1;
        int commonRatio = random.nextInt(5) + 1;

        int[] progression = generateProgression(firstTerm, commonRatio, progressionLength);
        String[] progressionWithHidden = hideElement(progression, hiddenIndex);

        StringBuilder question = new StringBuilder();
        for (String element : progressionWithHidden) {
            question.append(element).append(" ");
        }
        return question.toString().trim();
    }

    @Override
    public String getCorrectAnswer(String question) {
        String[] elements = question.split(" ");
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals("..")) {
                int[] progression = generateProgressionFromQuestion(question);
                return Integer.toString(progression[i]);
            }
        }
        return "";
    }

    private int[] generateProgression(int firstTerm, int commonRatio, int length) {
        int[] progression = new int[length];
        progression[0] = firstTerm;

        for (int i = 1; i < length; i++) {
            progression[i] = progression[i - 1] * commonRatio;
        }

        return progression;
    }

    private String[] hideElement(int[] progression, int hiddenIndex) {
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

    private int[] generateProgressionFromQuestion(String question) {
        String[] elements = question.split(" ");
        int[] progression = new int[elements.length];

        int firstTerm = findFirstTerm(elements);
        int secondTerm = findSecondTerm(elements, firstTerm);
        int commonRatio = secondTerm / firstTerm;

        progression[0] = firstTerm;
        for (int i = 1; i < elements.length; i++) {
            progression[i] = progression[i - 1] * commonRatio;
        }

        return progression;
    }

    private int findFirstTerm(String[] elements) {
        for (String element : elements) {
            if (!element.equals("..")) {
                return Integer.parseInt(element);
            }
        }
        throw new IllegalArgumentException("No valid first term found in the question.");
    }

    private int findSecondTerm(String[] elements, int firstTerm) {
        for (String element : elements) {
            if (isValidTerm(element, firstTerm)) {
                return Integer.parseInt(element);
            }
        }
        return firstTerm;
    }

    private boolean isValidTerm(String element, int firstTerm) {
        return !element.equals("..") && Integer.parseInt(element) != firstTerm;
    }
}