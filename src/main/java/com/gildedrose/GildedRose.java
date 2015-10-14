package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (AGED_BRIE.equals(item.name)) {
                item.updateAgedBrie();
            } else if (BACKSTAGE_PASSES.equals(item.name)) {
                item.updateBackstagePasses();
            } else if (SULFURAS.equals(item.name)) {
                item.updateSulfuras();
            } else {
                item.updateStandardItem();
            }
        }
    }

}