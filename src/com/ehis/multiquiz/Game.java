package com.ehis.multiquiz;

import com.ehis.multiquiz.entity.Category;
import com.ehis.multiquiz.utils.Chrono;
import com.ehis.multiquiz.utils.Input;
import com.ehis.multiquiz.utils.QuizFactory;
import com.ehis.multiquiz.utils.Score;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Game {

    private QuizFactory quiz;
    private Category category;
    private Chrono chrono = new Chrono();
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
        chrono.begin();
        while (round != 10) {
            quiz();
            createInput();
            round++;
        }
        chrono.end();
        this.time = chrono.getTime();
        stop();
    }

    private void quiz() {
        quiz.generate();
        while (quiz.isAlreadyUsed()) {
            answer = quiz.generate();
        }
        quiz.print();
    }

    private void createInput() {
        String input = new Input().nextLine("\nChoose : ");
        while (!isAnswer(input)) {
            System.err.println("\nInvalid answer, Please choose (A, B, C, D) !");
            input = new Input().nextLine("\nChoose : ");
        }
        chrono.end();
        this.time = chrono.getTime();
        verifyAnswer(input);
    }

    private void stop() {
        Score score = new Score(category, points, time);
        score.print();
        score.write();
    }

    private boolean isAnswer(String input) {
        List<String> answers = Arrays.asList("A", "B", "C", "D");
        return answers.contains(input);
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
