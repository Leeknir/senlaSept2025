package Task2;

import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("=== Конвертер валют ===");
        converter.displaySupportedCurrencies();
        System.out.println();

        boolean continueConversion = true;

        while (continueConversion) {
            System.out.print("Введите исходную валюту: ");
            String baseCurrency = scanner.nextLine().toUpperCase();

            if (!converter.isCurrencySupported(baseCurrency)) {
                System.out.println("Ошибка: валюта не поддерживается");
                continue;
            }

            System.out.print("Введите сумму для конвертации: ");
            double amount;

            try {
                amount = Double.parseDouble(scanner.nextLine());
                if (amount <= 0) {
                    System.out.println("Ошибка: сумма должна быть положительным числом");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное число");
                continue;
            }

            Map<String, Double> convertedAmounts = converter.convertCurrency(amount, baseCurrency);

            if (convertedAmounts != null) {
                System.out.println("\nРезультаты конвертации:");
                System.out.println(amount + " " + baseCurrency + " =");

                for (Map.Entry<String, Double> entry : convertedAmounts.entrySet()) {
                    System.out.printf("- %.2f %s\n", entry.getValue(), entry.getKey());
                }
            }

            System.out.print("\nХотите выполнить еще одну конвертацию? (да/нет): ");
            String response = scanner.nextLine().toLowerCase();

            if (!response.equals("да") && !response.equals("yes")) {
                continueConversion = false;
            }

            System.out.println();
        }

        System.out.println("Спасибо за использование конвертера валют!");
        scanner.close();
    }
}