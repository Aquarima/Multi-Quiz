package com.ehis.multiquiz;

import com.ehis.multiquiz.entity.Category;
import com.ehis.multiquiz.utils.Input;

public class Main {

    public static void main(String[] args) {

        Game game;
        String input;

        do {
            input = new Input().nextLine("Category : ");
        } while (!Category.isCategory(input));

        game = new Game(Category.valueOf(input));
        game.start();

    }
}
