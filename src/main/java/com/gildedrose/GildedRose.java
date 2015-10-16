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
            if (item.name.equals(AGED_BRIE)) {
                item.increaseQuality();
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                item.increaseQuality();

                if (item.name.equals(BACKSTAGE_PASSES)) {
                    if (item.expiresIn(ELEVEN_DAYS)) {
                        item.increaseQuality();
                    }

                    if (item.expiresIn(SIX_DAYS)) {
                        item.increaseQuality();
                    }
                }
            } else {
                if (item.name.equals(SULFURAS)) {

                } else {
                    item.decreaseQuality();
                }
            }

            if (item.name.equals(SULFURAS)) {

            } else {
                item.decreaseSellIn();
            }

            if (item.isExpired()) {
                if (item.name.equals(AGED_BRIE)) {
                    item.increaseQuality();
                } else {
                    if (item.name.equals(BACKSTAGE_PASSES)) {
                        item.setQualityToMinimum();
                    } else {
                        if (item.name.equals(SULFURAS)) {
                            continue;
                        }
                        item.decreaseQuality();
                    }
                }
            }
        }
    }
}