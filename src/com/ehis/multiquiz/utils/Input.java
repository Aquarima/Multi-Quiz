package com.ehis.multiquiz.utils;

import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);

    public String nextLine(String topic) {
        System.out.print(topic);
        String input = scanner.nextLine();

        while (verify(input)) {
            System.out.print(topic);
            input = scanner.nextLine();
        }

        return input.toUpperCase();
    }

    private boolean verify(String input) {
        if (input.isEmpty()) System.err.println("Input cannot be empty !");
        return input.isEmpty();
    }

}
