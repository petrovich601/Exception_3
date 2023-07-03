package dz3;

/*
Задача1. Напишите программу-калькулятор, которая запрашивает у пользователя
два числа и выполняет операцию возведения первого числа в степень второго числа.
Если введены некорректные числа или происходит деление на ноль,
необходимо обработать соответствующие исключения и вывести информативное
сообщение об ошибке.
Важно! С использованием принципа одного уровня абстракции!
**В этой задаче мы создаем класс PowerCalculator, который содержит метод
calculatePower(), выполняющий операцию возведения числа в степень.
Если введено некорректное основание (ноль) и отрицательная степень,
выбрасывается исключение InvalidInputException.
 */

import java.util.Scanner;

public class PowerCalculator {
    public static double calculatePower(double a, double b) throws InvalidInputException {
        if (b <= 0) {
            throw new InvalidInputException("Ошибка: Введено некорректное число");
        }
        return Math.pow(a , b);
    }

    public static void main(String[] args) {
        try {
            double a = getInputNumber("Введите первое число: ");
            double b = getInputNumber("Введите второе число: ");

            double result = calculatePower(a, b);
            System.out.println("Результат возведения в степень: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введено некорректное число");
        } catch (InvalidInputException e) {
            handleInvalidInputException(e);
        }
    }

    private static double getInputNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    private static void handleInvalidInputException(InvalidInputException e) {
        System.out.println("Ошибка: " + e.getMessage());
    }
    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}
