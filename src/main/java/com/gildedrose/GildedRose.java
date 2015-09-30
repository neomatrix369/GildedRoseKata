package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Aged Brie")) {
                if (items[i].quality < 50) {
                    increaseQuality(items[i]);
                    decreaseSellInDays(items[i]);

                    increaseQualityDependingOnSellIn(items[i], 0);
                }
            }

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseQuality(items[i]);

                if (items[i].quality < 50) {
                    increaseQualityDependingOnSellIn(items[i], 11);

                    increaseQualityDependingOnSellIn(items[i], 6);
                }

                decreaseSellInDays(items[i]);

                setQualityToMinSellInIfSellInIsLessThanMininumSellIn(items[i], 0);
            }

            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                if (items[i].quality > 0) {
                    decreaseQuality(items[i]);
                    decreaseSellInDays(items[i]);

                    decreaseQualityIfSellInIsLessThanMinimumSellIn(items[i], 0);
                }
            }

        }
    }

    private void decreaseQualityIfSellInIsLessThanMinimumSellIn(Item item, int minimumSellIn) {
        if (item.sellIn < minimumSellIn) {
            decreaseQuality(item);
        }
    }

    private void setQualityToMinSellInIfSellInIsLessThanMininumSellIn(Item item, int minSellIn) {
        if (item.sellIn < minSellIn) {
            item.quality = minSellIn;
        }
    }

    private void increaseQualityDependingOnSellIn(Item item, int minimumSelling) {
        if (item.sellIn < minimumSelling) {
            increaseQuality(item);
        }
    }

    private void decreaseSellInDays(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }
}