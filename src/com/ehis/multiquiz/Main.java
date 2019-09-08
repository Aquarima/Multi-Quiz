package com.ehis.multiquiz;

import com.ehis.multiquiz.utils.Input;

public class Main {
    public static void main(String[] args) {
        System.out.print("Catégorie : ");
        String input = new Input().getInput();
        Game game = new Game(input);
    }
}
