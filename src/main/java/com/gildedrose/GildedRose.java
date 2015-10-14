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
            if (AGED_BRIE.equals(item.name)
                    || BACKSTAGE_PASSES.equals(item.name)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (BACKSTAGE_PASSES.equals(item.name)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            } else {
                if (item.quality > 0) {
                    if (SULFURAS.equals(item.name)) {

                    } else {
                        item.quality = item.quality - 1;
                    }
                }
            }

            if (SULFURAS.equals(item.name)) {

            } else {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (AGED_BRIE.equals(item.name)) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                } else {
                    if (BACKSTAGE_PASSES.equals(item.name)) {
                        item.quality = item.quality - item.quality;
                    } else {
                        if (item.quality > 0) {
                            if (SULFURAS.equals(item.name)) {
                                continue;
                            }
                            item.quality = item.quality - 1;
                        }
                    }
                }
            }
        }
    }
}