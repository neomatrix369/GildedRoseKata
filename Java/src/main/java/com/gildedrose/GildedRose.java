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
            }

            if ((items[i].name.equals(AGED_BRIE)
                    || items[i].name.equals(BACK_STAGE_PASSES)) &&
                       (items[i].quality < 50)) {
                    increaseQuality(items[i]);
                    increaseQualityOfBackStagePasses(items[i], 11, 50);
                    increaseQualityOfBackStagePasses(items[i], 6, 50);
            }

            decreaseSellInForAllItemsOtherThanSulfurus(items[i]);

            if (items[i].sellIn < 0) {
                if (items[i].name.equals(AGED_BRIE)) {
                    increaseQuality(items[i], 50);
                }

                if (!items[i].name.equals(AGED_BRIE)) {
                    if (!items[i].name.equals(BACK_STAGE_PASSES)) {
                        if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)
                                && (items[i].quality > 0)) {
                            decreaseQuality(items[i]);
                        }
                    }

                    if (items[i].name.equals(BACK_STAGE_PASSES)) {
                        items[i].quality = 0;
                    }
                }
            }
        }
    }

    private void decreaseSellInForAllItemsOtherThanSulfurus(Item item) {
        if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void increaseQualityOfBackStagePasses(Item item,
                                                  int minimumSellIn,
                                                  int maximumQuality) {
        if (item.name.equals(BACK_STAGE_PASSES)
            && (item.sellIn < minimumSellIn)
                && (item.quality < maximumQuality)) {
                increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private void increaseQuality(Item item, int maximumQuality) {
        if (item.quality < maximumQuality) {
            increaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }
}
