package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                if (item.quality < 50) {
                    item.increaseQuality();
                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality < 50) {
                    item.increaseQuality();
                }
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if ((item.sellIn < 11) && (item.quality < 50)) {
                        item.increaseQuality();
                    }

                    if ((item.sellIn < 6) && (item.quality < 50)) {
                        item.increaseQuality();
                    }
                }
            } else {
                if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    if (item.quality > 0) {
                    }
                } else {
                    if (item.quality > 0) {
                        item.decreaseQuality();
                    }
                }
            }

            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {

            } else {
                item.decreaseSellIn();
            }


            if (item.name.equals("Aged Brie")) {
                if (item.sellIn < 0) {
                    if (item.quality < 50) {
                        item.increaseQuality();
                    }
                }
            } else {

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 0) {
                        item.setQualityToZero();
                    }
                } else {
                    if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        if (item.sellIn < 0) {
                            if (item.quality > 0) {
                            }
                        }
                    } else {
                        if (item.sellIn < 0) {
                            if (item.quality > 0) {

                                item.decreaseQuality();
                            }
                        }
                    }
                }
            }
        }
    }
}
