package Task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangmanGame game = new HangmanGame();

        System.out.println("=== Игра 'Виселица' ===");
        System.out.println("Правила: угадайте слово по буквам. У вас есть 6 попыток.");
        game.startNewGame();

        while (!game.isGameOver()) {
            game.displayGameInfo();

            System.out.print("\nВведите букву: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1) {
                System.out.println("Пожалуйста, введите только одну букву!");
                continue;
            }

            char letter = input.charAt(0);

            if (!Character.isLetter(letter)) {
                System.out.println("Пожалуйста, введите букву русского алфавита!");
                continue;
            }

            game.processGuess(letter);
        }

        System.out.print("\nХотите сыграть еще раз? (да/нет): ");
        String playAgain = scanner.nextLine().toLowerCase();

        if (playAgain.equals("да") || playAgain.equals("yes")) {
            main(args); // Рекурсивный вызов для новой игры
        } else {
            System.out.println("Спасибо за игру!");
        }

        scanner.close();
    }
}