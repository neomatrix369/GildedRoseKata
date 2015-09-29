package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                decreaseQualityIfQualityIsGreaterThan_0_AndItemIsNotSulfuras(items[i]);
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        increaseQualityIfQualityIsLessThan_50_AndSellInIsLessThanMaxSellIn(items[i], 11);
                        increaseQualityIfQualityIsLessThan_50_AndSellInIsLessThanMaxSellIn(items[i], 6);
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        setQualityToZero(items[i]);
                    } else {
                        decreaseQualityIfQualityIsGreaterThan_0_AndItemIsNotSulfuras(items[i]);
                    }
                } else {
                    increaseQualityIfQualityIsLessThan_50(items[i]);
                }
            }
        }
    }

    private void setQualityToZero(Item item) {
        item.quality = 0;
    }

    private void increaseQualityIfQualityIsLessThan_50_AndSellInIsLessThanMaxSellIn(Item item, int maximumSellIn) {
        if (item.sellIn < maximumSellIn) {
            increaseQualityIfQualityIsLessThan_50(item);
        }
    }

    private void increaseQualityIfQualityIsLessThan_50(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQualityIfQualityIsGreaterThan_0_AndItemIsNotSulfuras(Item item) {
        if (item.quality > 0) {
            decreaseQualityIfItemIsNotSulfuras(item);
        }
    }

    private void decreaseQualityIfItemIsNotSulfuras(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = item.quality - 1;
        }
    }
}