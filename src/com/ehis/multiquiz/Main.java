package com.ehis.multiquiz;

import com.ehis.multiquiz.entity.Category;
import com.ehis.multiquiz.utils.Input;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> categories = Arrays.asList("CUSTOM");
        String input;

        do {
            System.out.print("Catégorie : ");
            input = new Input().getInput();
        } while (!categories.contains(input));

        Game game = new Game(Category.valueOf(input));
    }
}
