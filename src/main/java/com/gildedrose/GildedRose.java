package com.gildedrose;

class GildedRose {
    protected static final String AGED_BRIE = "Aged Brie";
    protected static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    protected static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private final Items items;

    public GildedRose(Items items) {
        this.items = items;
    }

    public void updateQuality() {
        items.update();
    }

}