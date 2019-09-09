package com.ehis.multiquiz;

import com.ehis.multiquiz.entity.Category;
import com.ehis.multiquiz.utils.Input;
import com.ehis.multiquiz.utils.QuizFactory;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private String answer;
    private int points = 0;
    private int round = 10;

    Game(Category category) {

        QuizFactory quiz = new QuizFactory(category);

        long start = System.currentTimeMillis();

        while (round != 10) {

            answer = quiz.generate();
            quiz.print();

            System.out.print("\n\nChoice : ");
            String input = new Input().getInput();

            if (matches(input)) {
                System.out.println("\nGood Answer (+1) !");
                points++;
            }else System.out.println("\nBad Answer (+0) !");

            round++;
        }

        long time = (System.currentTimeMillis() - start) /1000;

        GameEnd end = new GameEnd(category, time, points);

    }

    private boolean matches(String input) {
        return input.equals(answer);
    }
}
