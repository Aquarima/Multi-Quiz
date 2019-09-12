package com.ehis.multiquiz.entity;

import java.util.ArrayList;
import java.util.List;

public enum Category {

    CUSTOM("custom_quiz.txt"), YOUTUBE("youtube_quiz.txt");

    private String filename;

    Category(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public static boolean isCategory(String input) {
        List<String> list = new ArrayList<>();
        for (Category category : Category.values()) list.add(category.toString());
        return list.contains(input);
    }
}
