package com.ehis.multiquiz;

import com.ehis.multiquiz.utils.Input;
import com.ehis.multiquiz.utils.Quiz;

public class Game {

    private Quiz quiz;
    private int hits = 0;
    private int round = 8;

    public Game(String category) {

        quiz = new Quiz(category.toUpperCase());

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

        long end = System.currentTimeMillis();

        GameEnding(category, (end - start / 1000), hits);

    }

    private void GameEnding(String category, long time, int hits) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n###### STATISTIQUES ######");
        builder.append("\nCatégorie : " + category);
        builder.append("\nTemps : " + time + "s");
        builder.append("\nScore : " + hits + "/" + 10);
        builder.append("\n##########################");
        System.out.println(builder);
    }

    private boolean matches(String input) {
        return input.equals(quiz.getAnswer());
    }

}
