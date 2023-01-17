package org.example.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Reader {
    public void addFileToIntegerArray(String path, List<Integer> name) {
        try (Scanner scanner = new Scanner(new FileReader(path))) {
            while (scanner.hasNext()) {
                name.add(scanner.nextInt());
            }
        } catch (InputMismatchException ex) {
            System.out.println("Ошибка типа введенных данных в файле " + path);
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка. Файл " + path + " не найден.");
        } catch (Exception ex) {
            throw new RuntimeException(ex.toString());
        }
    }

    public void addFileToStringArray(String path, List<String> name) {
        try (Scanner scanner = new Scanner(new FileReader(path))) {
            while (scanner.hasNext()) {
                name.add(scanner.nextLine());
            }
        } catch (InputMismatchException ex) {
            System.out.println("Ошибка типа введенных данных " + path);
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка. Файл " + path + " не найден.");
        } catch (Exception ex) {
            throw new RuntimeException(ex.toString());
        }
    }
}
