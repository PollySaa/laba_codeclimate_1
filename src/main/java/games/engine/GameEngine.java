package games.engine;

import java.util.Scanner;

public class GameEngine {

    private final String gameRules;
    private final String gameName;
    private final int maxRounds;

    public GameEngine(String gameName, String gameRules, int maxRounds) {
        this.gameName = gameName;
        this.gameRules = gameRules;
        this.maxRounds = maxRounds;
    }

    public void startGame(Scanner scanner, GameLogic gameLogic) {
        greetUser();
        String name = askForName(scanner);
        greetUserByName(name);
        explainRules();

        int score = 0;

        while (score < maxRounds) {
            String question = gameLogic.generateQuestion();
            String correctAnswer = gameLogic.getCorrectAnswer(question);

            displayQuestion(question);
            String userAnswer = getUserAnswer(scanner);

            if (checkAnswer(userAnswer, correctAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                handleWrongAnswer(userAnswer, correctAnswer, name);
                return;
            }
        }

        congratulateUser(name);
    }

    private void greetUser() {
        System.out.println("Welcome to the Brain Games!");
    }

    private String askForName(Scanner scanner) {
        System.out.print("May I have your name? ");
        return scanner.nextLine();
    }

    private void greetUserByName(String name) {
        System.out.println("Hello, " + name + "!");
    }

    private void explainRules() {
        System.out.println(gameRules);
    }

    private void displayQuestion(String question) {
        System.out.println("Question: " + question);
    }

    private String getUserAnswer(Scanner scanner) {
        System.out.print("Your answer: ");
        return scanner.nextLine();
    }

    private boolean checkAnswer(String userAnswer, String correctAnswer) {
        return userAnswer.equals(correctAnswer);
    }

    private void handleWrongAnswer(String userAnswer, String correctAnswer, String name) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + name + "!");
    }

    private void congratulateUser(String name) {
        System.out.println("Congratulations, " + name + "!");
    }
}