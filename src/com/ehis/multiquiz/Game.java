package com.ehis.multiquiz;

import com.ehis.multiquiz.entity.Category;
import com.ehis.multiquiz.utils.Input;
import com.ehis.multiquiz.utils.Quiz;

import java.util.Arrays;
import java.util.List;

public class Game {

    private Quiz quiz;
    private int hits = 0;
    private int round = 8;

     public Game(Category category) {

        quiz = new Quiz(category);

        long start = System.currentTimeMillis();

        while (round != 10) {

            quiz.generate();
            quiz.print();

            System.out.print("\n\nChoix : ");
            String input = new Input().getInput();

            if (matches(input)) {
                System.out.println("\nBonne réponse !");
                hits++;
            }else System.out.println("\nMauvaise réponse !");

            round++;
        }

        long time = (System.currentTimeMillis() - start) /1000;

        GameEnd end = new GameEnd(time, hits);

    }

    private boolean matches(String input) {
        return input.equals(quiz.getAnswer());
    }

    public List<Category> categories(List<Category> categories) {
        categories.addAll(Arrays.asList(Category.values()));
        return categories;
    }

}
