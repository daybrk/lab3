package com.example.lab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnnecessaryContent {

    public static final List<UnnecessaryContent.UnnecessaryItem> ITEMS = new ArrayList<>();
    public static final Map<String, UnnecessaryItem> ITEM_MAP = new HashMap<>();

    static {
        for (int i = 0; i < 25; i++){
            addItem(createScheduleData(i));
        }
    }

    private static void addItem(UnnecessaryContent.UnnecessaryItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static UnnecessaryItem createScheduleData(int i) {

        return new UnnecessaryItem(String.valueOf(i));
    }

    public static class UnnecessaryItem {
        public final String id;

        public UnnecessaryItem(String id) {
            this.id = id;
        }
    }

}
