package com.ehis.multiquiz.utils;

import com.ehis.multiquiz.Game;
import com.ehis.multiquiz.Main;
import com.ehis.multiquiz.entity.Category;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quiz {

    private String line;
    private String question;
    private String[] args;

    private ArrayList<String> elements = new ArrayList<>();
    private Random r = new Random();

    public Quiz(Category selection) {
        try {
            File file = new File("src/resources/" + selection.getFilename());
            read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read(File file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
        while ((line = br.readLine()) != null) {
            br.lines().forEach(this::add);
            isEmpty(line);
        }
    }

    private void add(String line) {
        elements.add(line);
    }

    private void isEmpty(String line) {
        if (line.isEmpty()) throw new RuntimeException("\nThis file cannot be used <Reason : Empty file>");
    }

    public void generate() {
        this.line = elements.get(r.nextInt(elements.size()));
        this.args = line.split(" -> ");
        this.question = args[0];
    }

    public void print() {
        String[] a1 = args[2].split(" - ");
        StringBuilder builder = new StringBuilder("\n-> ");
        builder.append(question);
        builder.append("\n\nA [" + a1[0] + "] B [" + a1[1] + "] C [" + a1[2] + "] D [" + a1[3] + "]");
        System.out.print(builder);
    }

    public String getAnswer() {
        return args[1];
    }

}
