package com.ehis.multiquiz;

import com.ehis.multiquiz.entity.Category;
import com.ehis.multiquiz.utils.Input;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        String input;

        do {
            input = new Input().nextLine("Category : ");
        } while (!Category.list().contains(input));

        game = new Game(Category.valueOf(input));
        game.start();

    }
}
