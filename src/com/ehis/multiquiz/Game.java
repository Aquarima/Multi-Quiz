package com.ehis.multiquiz;

import com.ehis.multiquiz.entity.Category;
import com.ehis.multiquiz.utils.Input;
import com.ehis.multiquiz.utils.QuizFactory;
import com.ehis.multiquiz.utils.Score;

public class Game {

    private QuizFactory quiz;
    private Category category;
    private String answer;
    private int round = 0;
    private int points = 0;
    private long time = 0;

    public Game() { }

    public Game(Category category) {
        this.category = category;
        this.quiz = new QuizFactory(category);
    }

    public void start() {
        long start = System.currentTimeMillis();
        while (round != 10) {
            quiz();
            createInput();
            round++;
        }
        time = (System.currentTimeMillis() - start) / 1000;
        stop();
    }

    private void quiz() {
        answer = quiz.generate();
        quiz.print();
    }

    private void createInput() {
        String input = new Input().nextLine("\nChoose : ");
        verifyAnswer(input);
    }

    private void stop() {
        Score score = new Score(category, points, time);
        score.print();
        score.write();
    }

    private void verifyAnswer(String input) {
        if (!input.equals(answer)) {
            System.err.println("\nBad Answer (+0)");
            return;
        }
        System.err.println("\nGood Answer (+1) !");
        points++;
    }

}
