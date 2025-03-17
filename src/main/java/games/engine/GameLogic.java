package games.engine;

public interface GameLogic {
    String generateQuestion();

    String getCorrectAnswer(String question);
}