package com.gildedrose;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Items {
    private List<Item> items = new ArrayList<>();

    public List<Item> getList() {
        return Collections.unmodifiableList(items);
    }

    public void add(Item item) {
        items.add(item);
    }

    void update() {
        for (Item item : getList()) {
            item.update();
        }
    }
}