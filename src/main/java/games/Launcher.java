package games;

import games.engine.GameEngine;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = getGameChoice(scanner);

        if (choice == 1) {
            startGeometricProgressionGame(scanner);
        } else if (choice == 2) {
            startLcmGame(scanner);
        } else {
            System.out.println("Неверная цифра!");
        }
    }

    private static int getGameChoice(Scanner scanner) {
        System.out.print("Введите число - 1, если хотите запустить игру 'Geometric Progression Game'" +
                "\nВведите число - 2, если хотите запустить игру 'LCM Game': ");

        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("Ошибка: Введено не число!");
            return -1;
        }
    }

    private static void startGeometricProgressionGame(Scanner scanner) {
        GameEngine gameEngine = new GameEngine("Geometric Progression Game",
                "What number is missing in the progression?", 3);
        gameEngine.startGame(scanner, new GeometricProgressionGame());
    }

    private static void startLcmGame(Scanner scanner) {
        GameEngine gameEngine = new GameEngine("LCM Game",
                "Find the smallest common multiple of given numbers.", 3);
        gameEngine.startGame(scanner, new LcmGame());
    }
}