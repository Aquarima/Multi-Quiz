package com.ehis.multiquiz.entity;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum Category {

    CUSTOM("custom_quiz.txt");

    private String filename;

    Category(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
