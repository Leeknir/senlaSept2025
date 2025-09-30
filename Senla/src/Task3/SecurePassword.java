package Task3;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecurePassword {
    private final SecureRandom random = new SecureRandom();
    private final String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=[]{};:'\\\"|,.<>/?";
    private final String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String lowercase = "abcdefghijklmnopqrstuvwxyz";
    private final String digits = "0123456789";
    private final String symbols = "!@#$%^&*()_+-=[]{};:'\\\"|,.<>/?";

    public String generatePassword(int length) {
        if (length < 8 || length > 12) {
            System.out.println("Ошибка: длина пароля должна быть от 8 до 12 символов");
            return null;
        }

        StringBuilder password = new StringBuilder();

        password.append(getRandomChar(uppercase));
        password.append(getRandomChar(lowercase));
        password.append(getRandomChar(digits));
        password.append(getRandomChar(symbols));

        for (int i = 4; i < length; i++) {
            password.append(getRandomChar(charset));
        }

        return shuffleString(password.toString());
    }

    private char getRandomChar(String characterSet) {
        int index = random.nextInt(characterSet.length());
        return characterSet.charAt(index);
    }

    private String shuffleString(String input) {
        List<Character> characters = new ArrayList<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);

        StringBuilder shuffled = new StringBuilder();
        for (char c : characters) {
            shuffled.append(c);
        }
        return shuffled.toString();
    }
}