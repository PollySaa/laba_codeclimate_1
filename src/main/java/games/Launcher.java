package games;

import games.engine.GameEngine;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число - 1, если хотите запустить игру 'Geometric Progression Game'" +
                "Введите число - 2, если хотите запустить игру 'LCM Game': ");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number == 1) {
                scanner = new Scanner(System.in);
                GameEngine gameEngine = new GameEngine("Geometric Progression Game",
                        "What number is missing in the progression?", 3);
                gameEngine.startGame(scanner, new GeometricProgressionGame());
            } else if (number == 2) {
                scanner = new Scanner(System.in);
                GameEngine gameEngine = new GameEngine("LCM Game", "Find the smallest common multiple of given numbers.", 3);
                gameEngine.startGame(scanner, new LcmGame());
            } else {
                System.out.println("Неверная цифра!");
            }
        } else {
            System.out.println("Ошибка: Введено не число!");
        }
    }
}
