package com.ehis.multiquiz.utils;

import com.ehis.multiquiz.entity.Category;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Score {

    private StringBuilder builder;
    private Category category;
    private int score;
    private long time;

    public Score(Category category, int score, long time) {
        this.category = category;
        this.score = score;
        this.time = time;
    }

    public void print() {

        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");

        builder = new StringBuilder();
        builder.append("\n####### [" + date.format(new Date()) + "] #######");
        builder.append("\n     Category : " + category);
        builder.append("\n       Time : " + time + "s");
        builder.append("\n       Score : " + score + "/" + 10);
        builder.append("\n############################");
        System.out.println(builder);
    }

    public void write() {
        try {
            File file = new File("src/resources/STATS.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(builder.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
