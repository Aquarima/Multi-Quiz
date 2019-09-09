package com.ehis.multiquiz;

import com.ehis.multiquiz.entity.Category;

class GameEnd {

    GameEnd(Category category, long time, int hits) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n####### STATISTICS #######");
        builder.append("\n    Category : " + category);
        builder.append("\n      Time : " + time + "s");
        builder.append("\n      Score : " + hits + "/" + 10);
        builder.append("\n##########################");
        System.out.println(builder);
    }

}
