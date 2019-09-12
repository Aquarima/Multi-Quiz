package com.ehis.multiquiz.utils;

import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);
    private String input = "";

    public String nextLine(String topic) {

        while (input.isEmpty()) {
            System.out.print(topic);
            input = scanner.nextLine();
        }

        return input.toUpperCase();
    }

}
