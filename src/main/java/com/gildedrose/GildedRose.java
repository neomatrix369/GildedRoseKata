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
            if (item.is(AGED_BRIE)) item.updateAgedBrie();
            else if (item.is(BACKSTAGE_PASSES)) item.updateBackstagePasses();
            else if (item.is(SULFURAS)) item.updateSulfuras();
            else item.updateStandardItem();
        }
    }
}