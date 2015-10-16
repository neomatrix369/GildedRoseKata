package com.gildedrose;

class GildedRose {
    protected static final String AGED_BRIE = "Aged Brie";
    protected static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    protected static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public static void updateQuality(Item[] items) {
        for (Item item : items) {
            if (!item.name.equals(AGED_BRIE)
                    && !item.name.equals(BACKSTAGE_PASSES)) {
                if (item.canDecreaseQuality()) {
                    if (!item.name.equals(SULFURAS)) {
                        item.quality.decrease();
                    }
                }
            } else {
                if (item.canIncreaseQuality()) {
                    item.increaseQuality();

                    if (item.name.equals(BACKSTAGE_PASSES)) {
                        if (item.sellIn < 11) {
                            if (item.canIncreaseQuality()) {
                                item.increaseQuality();
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.canIncreaseQuality()) {
                                item.increaseQuality();
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(BACKSTAGE_PASSES)) {
                        if (item.canDecreaseQuality()) {
                            if (!item.name.equals(SULFURAS)) {
                                item.decreaseQuality();
                            }
                        }
                    } else {
                        item.quality.setToMinimum();
                    }
                } else {
                    if (item.canIncreaseQuality()) {
                        item.increaseQuality();
                    }
                }
            }
        }
    }
}
