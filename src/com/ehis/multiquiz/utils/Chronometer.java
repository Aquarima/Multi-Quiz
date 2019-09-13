package com.ehis.multiquiz.utils;

public class Chronometer {

    private long start;
    private long end;

    public void start() {
        this.start = System.currentTimeMillis();
    }

    public void end() {
        this.end = System.currentTimeMillis();
    }

    public long getTime() {
        return (end - start) / 1000;
    }

}
