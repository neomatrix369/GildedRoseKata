package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class Items {
    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    void update() {
        for (Item item : items) {
            item.update();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Item item: items) {
            result.append(item);
            result.append("\r");
        }
        return result.toString();
    }
}