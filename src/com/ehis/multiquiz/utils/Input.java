package com.ehis.multiquiz.utils;

import java.util.Scanner;

public class Input {

    private Scanner scanner;
    private String input;

    public Input() {
        this.scanner = new Scanner(System.in);
        this.input = scanner.nextLine();
    }

    private void isValid() {
        if (input.isEmpty()) throw new RuntimeException("Input cannot be empty !");
    }

    public String getInput() {
        return input;
    }
}
