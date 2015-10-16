package com.gildedrose;

class GildedRose {
    protected static final String AGED_BRIE = "Aged Brie";
    protected static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    protected static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    protected static final Days ELEVEN_DAYS = new Days(11);
    protected static final Days SIX_DAYS = new Days(6);

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality(Item[] items) {
        for (Item item : items) {
            if (item.is(AGED_BRIE)) {
                item.updateAgedBrie();
            } else if (item.is(BACKSTAGE_PASSES)) {
                item.updateBackstagePasses();
            } else {
                if (item.is(SULFURAS)) {
                    item.updateSulfuras();
                } else {
                    item.updateStandardItem();
                }
            }
        }
    }

}