package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input:");
        calc(scanner.nextLine());
    }

    public static void calc(String input) {
        Calculator calculator = new Calculator();
        calculator.dataProcessing(input);
    }


}