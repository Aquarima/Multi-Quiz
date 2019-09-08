package com.ehis.multiquiz.utils;

import java.util.Scanner;

public class Input {

    private Scanner scanner;
    private String input;

    public Input() {
        this.scanner = new Scanner(System.in);
        this.input = scanner.nextLine();
    }

    public String getInput() {
        return input.toUpperCase();
    }
}
