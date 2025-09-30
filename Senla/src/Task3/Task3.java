package Task3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecurePassword generator = new SecurePassword();

        System.out.print("Введите длину пароля (8-12 символов): ");
        int length = scanner.nextInt();

        String password = generator.generatePassword(length);
        if (password != null) {
            System.out.println("Сгенерированный пароль: " + password);
        }

        scanner.close();
    }
}