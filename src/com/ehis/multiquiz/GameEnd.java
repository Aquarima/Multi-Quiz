package com.ehis.multiquiz;

import com.ehis.multiquiz.entity.Category;

class GameEnd {

    GameEnd(Category category, long time, int points) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n####### STATISTICS #######");
        builder.append("\n    Category : " + category);
        builder.append("\n      Time : " + time + "s");
        builder.append("\n      Score : " + points + "/" + 10);
        builder.append("\n##########################");
        System.out.println(builder);
    }

}
