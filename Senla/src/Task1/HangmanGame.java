package Task1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HangmanGame {
    private final String[] WORDS = {"программирование", "компьютер", "алгоритм", "интерфейс", "база данных",
            "фреймворк", "переменная", "функция", "объект", "класс"};
    private final int MAX_ATTEMPTS = 6;

    private final Random random = new Random();
    private String secretWord;
    private Set<Character> guessedLetters;
    private int remainingAttempts;
    private boolean gameWon;

    public HangmanGame() {
        initializeGame();
    }

    private void initializeGame() {
        secretWord = WORDS[random.nextInt(WORDS.length)];
        guessedLetters = new HashSet<>();
        remainingAttempts = MAX_ATTEMPTS;
        gameWon = false;
    }

    public void processGuess(char letter) {
        if (guessedLetters.contains(letter)) {
            System.out.println("Вы уже вводили эту букву!");
            return;
        }

        guessedLetters.add(letter);

        if (secretWord.indexOf(letter) >= 0) {
            System.out.println("Верно! Буква '" + letter + "' есть в слове.");
        } else {
            remainingAttempts--;
            System.out.println("Неверно! Буквы '" + letter + "' нет в слове.");
        }

        checkGameStatus();
    }

    public String getCurrentWordState() {
        StringBuilder currentState = new StringBuilder();

        for (char c : secretWord.toCharArray()) {
            if (guessedLetters.contains(c) || c == ' ') {
                currentState.append(c);
            } else {
                currentState.append('_');
            }
        }

        return currentState.toString();
    }

    private void checkGameStatus() {
        String currentState = getCurrentWordState();
        gameWon = !currentState.contains("_");

        if (gameWon) {
            System.out.println("Поздравляем! Вы угадали слово: " + secretWord);
        } else if (remainingAttempts <= 0) {
            System.out.println("Игра окончена! Загаданное слово было: " + secretWord);
        }
    }

    public boolean isGameOver() {
        return gameWon || remainingAttempts <= 0;
    }

    public void displayGameInfo() {
        System.out.println("\nТекущее состояние: " + getCurrentWordState());
        System.out.println("Осталось попыток: " + remainingAttempts);
        System.out.println("Использованные буквы: " + guessedLetters);
        drawHangman();
    }

    private void drawHangman() {
        String[] hangmanStates = {
                """
             -----
             |   |
                 |
                 |
                 |
                 |
            =========""",
                """
             -----
             |   |
             O   |
                 |
                 |
                 |
            =========""",
                """
             -----
             |   |
             O   |
             |   |
                 |
                 |
            =========""",
                """
             -----
             |   |
             O   |
            /|   |
                 |
                 |
            =========""",
                """
             -----
             |   |
             O   |
            /|\\  |
                 |
                 |
            =========""",
                """
             -----
             |   |
             O   |
            /|\\  |
            /    |
                 |
            =========""",
                """
             -----
             |   |
             O   |
            /|\\  |
            / \\  |
                 |
            ========="""
        };

        System.out.println(hangmanStates[MAX_ATTEMPTS - remainingAttempts]);
    }

    public void startNewGame() {
        initializeGame();
        System.out.println("Новая игра началась! Загадано слово из " + secretWord.length() + " букв.");
    }
}