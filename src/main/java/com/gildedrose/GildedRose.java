package com.gildedrose;

class GildedRose {

    ItemList<Item> items;

    public GildedRose(ItemList items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items.asList()) {
            if (item.name.equals("Aged Brie")) {
                if (item.quality < 50) {
                    increaseQuality(item);
                    decreaseSellInDays(item);

                    increaseQualityDependingOnSellIn(item, 0);
                }
            }

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseQuality(item);

                if (item.quality < 50) {
                    increaseQualityDependingOnSellIn(item, 11);

                    increaseQualityDependingOnSellIn(item, 6);
                }

                decreaseSellInDays(item);

                setQualityTo_0_IfSellInIsLessThanMinimumSellIn(item, 0);
            }

            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                if (item.quality > 0) {
                    decreaseQuality(item);
                    decreaseSellInDays(item);

                    decreaseQualityIfSellInIsLessThanMinimumSellIn(item, 0);
                }
            }

        }
    }

    private void decreaseQualityIfSellInIsLessThanMinimumSellIn(Item item, int minimumSellIn) {
        if (item.sellIn < minimumSellIn) {
            decreaseQuality(item);
        }
    }

    private void setQualityTo_0_IfSellInIsLessThanMinimumSellIn(Item item, int minimumSellIn) {
        if (item.sellIn < minimumSellIn) {
            item.quality = 0;
        }
    }

    private void increaseQualityDependingOnSellIn(Item item, int minimumSellin) {
        if (item.sellIn < minimumSellin) {
            increaseQuality(item);
        }
    }

    private void decreaseSellInDays(Item item) {
        item.sellIn--;
    }

    private void decreaseQuality(Item item) {
        item.quality--;
    }

    private void increaseQuality(Item item) {
        item.quality++;
    }

    public Item firstItem() {
        return items.firstItem();
    }
}