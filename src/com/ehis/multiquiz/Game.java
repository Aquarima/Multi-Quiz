package com.ehis.multiquiz;

import com.ehis.multiquiz.entity.Category;
import com.ehis.multiquiz.utils.Input;
import com.ehis.multiquiz.utils.QuizFactory;

public class Game {

    private QuizFactory quiz;
    private int hits = 0;
    private int round = 8;

    Game(Category category) {

        quiz = new QuizFactory(category);

        long start = System.currentTimeMillis();

        while (round != 10) {

            quiz.generate();
            quiz.print();

            System.out.print("\n\nChoice : ");
            String input = new Input().getInput();

            if (matches(input)) {
                System.out.println("\nGood Answer (+1) !");
                hits++;
            }else System.out.println("\nBad Answer (+0) !");

            round++;
        }

        long time = (System.currentTimeMillis() - start) /1000;

        GameEnd end = new GameEnd(category, time, hits);

    }

    private boolean matches(String input) {
        return input.equals(quiz.getAnswer());
    }
}
