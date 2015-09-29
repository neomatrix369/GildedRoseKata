package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Aged Brie")) {
                increaseQualityIfQualityIsLessThan_50(items[i]);
            }

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                items[i].quality = items[i].quality + 1;
            }

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseQualityIfQualityIsLessThan_50_AndSellInIsLessThanMaxSellIn(items[i], 11);
                increaseQualityIfQualityIsLessThan_50_AndSellInIsLessThanMaxSellIn(items[i], 6);
            }

            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && !items[i].name.equals("Sulfuras, Hand of Ragnaros")
                    && (items[i].quality > 0)) {
                items[i].quality = items[i].quality - 1;
            }

            decreaseSellInIfItemIsOtherThanSulfuras(items[i]);

            if (items[i].name.equals("Aged Brie")
                    && items[i].sellIn < 0
                    && items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
            }

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && items[i].sellIn < 0) {
                items[i].quality = 0;
            }

            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && !items[i].name.equals("Sulfuras, Hand of Ragnaros")
                    && (items[i].sellIn < 0)
                    && items[i].quality > 0) {
                items[i].quality = items[i].quality - 1;
            }
        }
    }

    private void decreaseSellInIfItemIsOtherThanSulfuras(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void decreaseQualityIfQualityIsGreaterThan_0_ForItemsOtherThanAgedBriedBackstagePassesAndSulfuras(Item item) {
        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                && !item.name.equals("Sulfuras, Hand of Ragnaros")
                && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void setQualityTo_0_BackstagePasses(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        }
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
}