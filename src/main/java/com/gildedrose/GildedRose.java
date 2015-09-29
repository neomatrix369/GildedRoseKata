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
                increaseQualityOfAgedBrieIfQualityIsLessThan_50(items[i]);

                increaseQualityOfBackstagePasses(items[i]);

                increaseQualityOfBackStagePassesIfQualityIsLessThan_50_AndSellInIsLessThan_11_Or_6(items[i]);
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                increaseQualityOfAgedBrieIfQualityIsLessThan_50(items[i]);

                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    items[i].quality = 0;
                }

                if (!items[i].name.equals("Aged Brie")) {
                    decreaseQualityIfQualityIsGreaterThan_0_AndItemIsNotSulfurasOrBackStagePasses(items[i]);
                }
            }
        }
    }

    private void increaseQualityOfBackstagePasses(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = item.quality + 1;
        }
    }

    private void increaseQualityOfAgedBrieIfQualityIsLessThan_50(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQualityIfQualityIsLessThan_50(item);
        }
    }

    private void increaseQualityOfBackStagePassesIfQualityIsLessThan_50_AndSellInIsLessThan_11_Or_6(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQualityIfQualityIsLessThan_50_AndSellInIsLessThanMaxSellIn(item, 11);
            increaseQualityIfQualityIsLessThan_50_AndSellInIsLessThanMaxSellIn(item, 6);
        }
    }

    private void decreaseQualityIfQualityIsGreaterThan_0_AndItemIsNotSulfurasOrBackStagePasses(Item item) {
        if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            decreaseQualityIfQualityIsGreaterThan_0_AndItemIsNotSulfuras(item);
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