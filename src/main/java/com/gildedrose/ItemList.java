package com.gildedrose;

import java.util.Arrays;
import java.util.List;

public class ItemList<Item> {
    Item[] items;

    public ItemList(Item[] items) {
        this.items = items;
    }

    public List<Item> asList() {
        return Arrays.asList(items);
    }

    public Item firstItem() {
        return items[0];
    }
}
