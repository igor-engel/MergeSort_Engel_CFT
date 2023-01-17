package org.example;

import org.example.script.Script;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class App {
    public static void main(String[] args) {
        List<String> files = startProgram();
        Script script = new Script(files.get(0), files.get(1), files.subList(2, files.size()));
        script.sortingScript();

        System.out.println("Выполнение завершено.");
    }

    public static List<String> startProgram() {
        List<String> commands = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите тип данных (-i для чисел, -s для строк): ");
        String line = scanner.nextLine();

        while (!line.equals("-i") && !line.equals("-s")) {
            System.out.println("Неверная команда, повторите (-i для чисел, -s для строк): ");
            line = scanner.nextLine();
        }

        commands.add(line);

        System.out.println("Введите режим сортировки (-a по возрастанию, -d по убыванию): ");
        line = scanner.nextLine();

        if (!line.equals("-a") && !line.equals("-d")) {
            System.out.println("Выполнится сортировка по возрастанию (по умолчанию)");
            commands.add("-a");
        } else {
            commands.add(line);
        }

        System.out.println("Введите путь к файлу: ");

        while (true) {
            line = scanner.nextLine();

            if (line.equals("sort")) {
                return commands;
            }

            commands.add(line);
            System.out.println("Введите путь к файлу или команду \"sort\": ");
        }
    }
}
