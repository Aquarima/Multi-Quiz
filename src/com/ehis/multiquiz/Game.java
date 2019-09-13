package com.ehis.multiquiz;

import com.ehis.multiquiz.entity.Category;
import com.ehis.multiquiz.utils.Chronometer;
import com.ehis.multiquiz.utils.Input;
import com.ehis.multiquiz.utils.QuizFactory;
import com.ehis.multiquiz.utils.Score;

import java.util.Arrays;
import java.util.List;

public class Game {

    private QuizFactory quiz;
    private Category category;
    private Chronometer chrono = new Chronometer();
    private String answer;
    private int round = 3;
    private int points = 0;
    private long time = 0;

    public Game(Category category) {
        this.category = category;
        this.quiz = new QuizFactory(category);
    }

    public void start() {
        chrono.start();
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
        this.answer = quiz.generate();
        quiz.print();
    }

    private void createInput() {
        chrono.start();
        String input = new Input().nextLine("\nChoose : ");
        while (!isAnswer(input)) {
            System.err.println("\nInvalid answer, Please choose (A, B, C, D) !");
            input = new Input().nextLine("\nChoose : ");
        }
        verifyAnswer(input);
        chrono.end();

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
