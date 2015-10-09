package com.gildedrose;


import java.util.Arrays;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = Arrays.copyOf(items, items.length);
    }

    public void updateQuality() {
        for (final Item item: items) {
            ProductUpdater.update(item);
        }
    }
}