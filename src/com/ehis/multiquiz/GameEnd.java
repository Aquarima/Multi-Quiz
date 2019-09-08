package com.ehis.multiquiz;

public class GameEnd {

    public GameEnd(long time, int hits) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n####### STATISTICS #######");
        builder.append("\nTime : " + time + "s");
        builder.append("\nScore : " + hits + "/" + 10);
        builder.append("\n##########################");
        System.out.println(builder);
    }

}
