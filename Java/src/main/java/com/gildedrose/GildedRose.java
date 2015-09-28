package com.gildedrose;

class GildedRose {
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String ANY_ITEM = "Any";
    public static final String BACK_STAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItemAgedBrie(items[i]);
            updateItemBackStagePasses(items[i]);
            updateAllOtherItems(items[i]);
        }
    }

    private void updateAllOtherItems(Item item) {
        if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACK_STAGE_PASSES)
                && !item.name.equals(SULFURAS_HAND_OF_RAGNAROS)
                && (item.quality > 0)) {
            decreaseQuality(item);
            decreaseSellIn(item);

            if ((item.quality > 0)
                    && (item.sellIn < 0)) {
                decreaseQuality(item);
            }
        }
    }

    private void updateItemBackStagePasses(Item item) {
        if (item.name.equals(BACK_STAGE_PASSES)) {
            if ((item.sellIn < 11)
                    && (item.quality < 50)) {
                increaseQuality(item);
            }

            if ((item.sellIn < 6)
                    && (item.quality < 50)) {
                increaseQuality(item);
            }

            increaseQuality(item);
            decreaseSellIn(item);

            if (item.sellIn < 0) {
                setQualityToZero(item);
            }
        }
    }

    private void updateItemAgedBrie(Item item) {
        if (item.name.equals(AGED_BRIE)
                && (item.quality < 50)) {
            increaseQuality(item);
            decreaseSellIn(item);

            if (item.sellIn < 0) {
                increaseQuality(item);
            }
        }
    }

    private void setQualityToZero(Item item) {
        item.quality = 0;
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }
}
