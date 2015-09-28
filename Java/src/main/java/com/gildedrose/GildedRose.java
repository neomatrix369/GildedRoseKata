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

            if (!items[i].name.equals(AGED_BRIE)
                    && !items[i].name.equals(BACK_STAGE_PASSES)
                    && !items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)
                    && (items[i].quality > 0)) {
                decreaseQuality(items[i]);
                decreaseSellIn(items[i]);
            }

            if (items[i].name.equals(AGED_BRIE)
                    && (items[i].quality < 50)) {
                increaseQuality(items[i]);
                decreaseSellIn(items[i]);
            }

            if (items[i].name.equals(BACK_STAGE_PASSES)) {
                if ((items[i].sellIn < 11)
                        && (items[i].quality < 50)) {
                    increaseQuality(items[i]);
                }

                if ((items[i].sellIn < 6)
                        && (items[i].quality < 50)) {
                    increaseQuality(items[i]);
                }
                increaseQuality(items[i]);
                decreaseSellIn(items[i]);

                if (items[i].name.equals(BACK_STAGE_PASSES)
                        && (items[i].sellIn < 0)) {
                    setQualityToZero(items[i]);
                }
            }

            if (items[i].name.equals(AGED_BRIE)
                    && (items[i].sellIn < 0)
                    && items[i].quality < 50) {
                increaseQuality(items[i]);
            }

            if (!items[i].name.equals(AGED_BRIE)
                    && !items[i].name.equals(BACK_STAGE_PASSES)
                    && !items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)
                    && (items[i].quality > 0)
                    && (items[i].sellIn < 0)) {
                decreaseQuality(items[i]);
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
