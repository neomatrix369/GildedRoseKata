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

                if (items[i].sellIn < 0) {
                    items[i].quality = 0;
                }
            }

            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                if (items[i].quality > 0) {
                    decreaseQuality(items[i]);
                    decreaseSellInDays(items[i]);

                    if (items[i].sellIn < 0) {
                        decreaseQuality(items[i]);
                    }
                }
            }

        }
    }

    private void increaseQualityDependingOnSellIn(Item item, int minimunSelling) {
        if (item.sellIn < minimunSelling) {
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