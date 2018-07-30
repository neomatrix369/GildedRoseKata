package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                updateAgedBrie(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstagePass(item);
            }

            if (!item.name.equals("Aged Brie") &&
                    !item.name.equals("Backstage passes to a TAFKAL80ETC concert") &&
                    !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                if (item.quality > 0) {
                    item.decreaseQuality();
                }

                item.decreaseSellIn();

                if (item.sellIn < 0 && item.quality > 0) {
                    item.decreaseQuality();
                }
            }
        }
    }

    private void updateBackstagePass(Item item) {
        if (item.quality < 50) {
            item.increaseQuality();
            
            if ((item.sellIn < 11) && (item.quality < 50)) {
                item.increaseQuality();
            }

            if ((item.sellIn < 6) && (item.quality < 50)) {
                item.increaseQuality();
            }
        }

        item.decreaseSellIn();

        if (item.sellIn < 0) {
            item.setQualityToZero();
        }
    }

    private void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            item.increaseQuality();
        }

        item.decreaseSellIn();

        if (item.sellIn < 0 && item.quality < 50) {
            item.increaseQuality();
        }
    }
}
