package com.example.lab3;

import java.util.ArrayList;
import java.util.List;

public class UnnecessaryContent {

    public static final List<UnnecessaryContent.UnnecessaryItem> ITEMS = new ArrayList<>();
    public static final List<UnnecessaryContent.UnnecessaryItem> ITEMS_2 = new ArrayList<>();



    static {

        for (int i = 0; i < 25; i++) {
            addItem(createUnnecessaryData(i), 0);
        }
        for (int i = 0; i < 7; i++) {
            addItem(createUnnecessaryData(i), 1);
        }
    }

    private static void addItem(UnnecessaryContent.UnnecessaryItem item, int TYPE) {
        if (TYPE == 0) {
            ITEMS.add(item);
        } else ITEMS_2.add(item);
    }

    private static UnnecessaryItem createUnnecessaryData(int i) {

        return new UnnecessaryItem(String.valueOf(i));
    }

    public static class UnnecessaryItem {
        public final String id;

        public UnnecessaryItem(String id) {
            this.id = id;
        }
    }

}
