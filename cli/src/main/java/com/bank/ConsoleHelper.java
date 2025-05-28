package main.java.com.bank;

import java.util.Scanner;

/**
 * Утилитарный класс для работы с консолью.
 */
public final class ConsoleHelper {

    /**
     * Приватный конструктор для предотвращения создания экземпляров утилитарного класса.
     */
    private ConsoleHelper() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Выводит сообщение в консоль.
     *
     * @param message Сообщение для вывода.
     */
    public static void printMessage(final String message) {
        System.out.println(message);
    }

    /**
     * Читает строку из консоли.
     *
     * @return Введенная строка.
     */
    public static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
