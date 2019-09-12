package com.ehis.multiquiz.utils;

import com.ehis.multiquiz.entity.Category;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class QuizFactory {

    private String line;
    private String question;
    private String[] args;

    private ArrayList<String> elements = new ArrayList<>();
    private ArrayList<String> usedElements = new ArrayList<>();
    private Random r = new Random();

    public QuizFactory(Category selection) {
        try {
            File file = new File("src/resources/quiz/" + selection.getFilename());
            read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read(File file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
        while ((line = br.readLine()) != null) br.lines().forEach(this::add);
    }

    private void add(String line) {
        elements.add(line);
    }

    public String generate() {
        this.line = elements.get(r.nextInt(elements.size()));
        this.args = line.split(" -> ");
        this.usedElements.add(args[0]);
        this.question = args[0];
        return args[1];
    }

    public void print() {
        String[] a1 = args[2].split(" - ");
        StringBuilder builder = new StringBuilder("\n-> ");
        builder.append(question);
        builder.append("\n\nA [" + a1[0] + "] B [" + a1[1] + "] C [" + a1[2] + "] D [" + a1[3] + "]");
        System.out.print(builder);
    }

    public boolean isAlreadyUsed() {
        return usedElements.contains(args[0]);
    }

}
