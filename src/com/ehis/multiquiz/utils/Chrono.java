package com.ehis.multiquiz.utils;

public class Chrono {

    private long start;
    private long end;

    public void begin() {
        this.start = System.currentTimeMillis();
    }

    public void end() {
        this.end = System.currentTimeMillis();
    }

    public long getTime() {
        return (end - start) / 1000;
    }
}
