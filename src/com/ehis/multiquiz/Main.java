package com.ehis.multiquiz;

import com.ehis.multiquiz.entity.Category;
import com.ehis.multiquiz.utils.Input;

public class Main {
    public static void main(String[] args) {

        String input;

        do {
            System.out.print("Category : ");
            input = new Input().getInput();
        } while (!Category.list().contains(input));

        Game game = new Game(Category.valueOf(input));
    }
}
