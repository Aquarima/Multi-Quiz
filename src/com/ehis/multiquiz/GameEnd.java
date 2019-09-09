package com.ehis.multiquiz;

import com.ehis.multiquiz.entity.Category;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class GameEnd {

    GameEnd(Category category, long time, int points) {

        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");

        StringBuilder builder = new StringBuilder();
        builder.append("\n####### [" + date.format(new Date()) + "] #######");
        builder.append("\n     Category : " + category);
        builder.append("\n       Time : " + time + "s");
        builder.append("\n       Score : " + points + "/" + 10);
        builder.append("\n############################");
        System.out.println(builder);
        write(builder);
    }

    private void write(StringBuilder builder) {
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
