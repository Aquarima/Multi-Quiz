package com.ehis.multiquiz.entity;

public enum Category {

    CUSTOM("custom_quiz.txt"), YOUTUBE("youtube_quiz.txt");

    private String filename;

    Category(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
