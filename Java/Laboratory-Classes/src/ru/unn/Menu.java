package ru.unn;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final List<Complex> complexList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void add2ComplexList(double re, double im) {
        complexList.add(new Complex(re, im));
    }

    public void removeFromComplexList(int index) {
        complexList.remove(index);
    }

    public void showMainMenu() {
        System.out.println("----------MENU----------");
        System.out.println(
                """
                        1. Список комплексных чисел
                        2. Создать комплексное число
                        3. Удалить комплексное число
                        4. Совершить арифметическую операцию над числами
                        5. Выход
                        """);

        int choice;
        try {
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showList();
                case 2 -> createComplex();
                case 3 -> removeComplex();
                case 4 -> operationWithComplex();
                case 5 -> {
                    System.out.println("See you soon!");
                    System.exit(1);
                }
                default -> System.out.println("Invalid input");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }

        scanner.nextLine();


    }

    public void showList() {
        if (complexList.size() == 0) {
            System.out.println("Пусто!");
        } else {
            String complexStr = null;
            for (int i = 0; i < complexList.size(); i++) {
                System.out.print(i + 1 + ". ");
                Complex complex = complexList.get(i);
                printComplex(complex);
            }
        }
    }

    public void createComplex() {
        System.out.println("Введите real и imaginary части");
        try {
            double real = scanner.nextDouble();
            double imag = scanner.nextDouble();
            System.out.print("Создано число: ");
            printComplex(new Complex(real, imag));
            complexList.add(new Complex(real, imag));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public void removeComplex() {
        if(complexList.size() == 0) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Укажите номер числа, которое нужно удалить:");
            showList();

            int choice;
            try {
                choice = scanner.nextInt();
                complexList.remove(choice - 1);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid index");
            }
        }
    }

    public void operationWithComplex() {
        Complex c1 = inputComplexWithChoice();
        char operation = inputOperation();
        Complex c2 = inputComplexWithChoice();

        Complex complex = null;
        switch (operation) {
            case '+' -> complex = c1.add(c2);
            case '-' -> complex = c1.sub(c2);
            case '*' -> complex = c1.mul(c2);
            case '/' -> complex = c1.div(c2);
        }
        System.out.print("Результат: ");
        printComplex(complex);
    }

    public char inputOperation() {
        System.out.println("Выбери операцию: +, -, *, /");

        char choice = 0;
        try {
            choice = scanner.next().charAt(0);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }

        char returnChar = 0;
        switch (choice) {
            case '+' -> returnChar = '+';
            case '-' -> returnChar = '-';
            case '*' -> returnChar = '*';
            case '/' -> returnChar = '/';
            default -> {
                System.out.println("Invalid input. Operation dy default: +");
                returnChar = '+';
            }
        }

        return returnChar;
    }

    public Complex inputComplexWithChoice() {
        System.out.println("Выбрать из уже существующих или ввести новое?");
        String operationMenu =
                """
                        1. Выбрать
                        2. Новое
                        """;
        System.out.println(operationMenu);

        Complex complex = null;
        int choice;
        try {
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> complex = pickComplex();
                case 2 -> complex = inputComplex();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }

        return complex;
    }

    public Complex inputComplex() {
        System.out.println("Введите real и imaginary части");
        double real = 0;
        double imag = 0;
        try {
            real = scanner.nextDouble();
            imag = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
        return new Complex(real, imag);
    }

    public void printComplex(Complex complex) {
        String complexStr;

        if (complex.getRe() == 0 && complex.getIm() == 0) {
            complexStr = "0";
        } else if (complex.getRe() == 0) {
            complexStr = complex.getIm() > 0 ?
                    "i*" + complex.getIm() :
                    "-i*" + -complex.getIm();
        } else if (complex.getIm() == 0) {
            complexStr = complex.getRe() + "";
        } else {
            complexStr = complex.getRe() + " " +
                    (complex.getIm() > 0 ?
                            "+ i*" + complex.getIm() :
                            "- i*" + -complex.getIm());
        }

        System.out.println(complexStr);
    }

    public Complex pickComplex() {

        if(complexList.size() == 0) {
            System.out.println("Список пуст\nВведи число с клавиатуры");

            return inputComplex();
        } else {
            System.out.println("Укажи номер нужного числа:");
            showList();

            int choice = -1;
            try {
                choice = scanner.nextInt();
                if(choice < 0 || choice > complexList.size()) {
                    System.out.println("Invalid index");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
            return complexList.get(choice - 1);
        }
    }

}
