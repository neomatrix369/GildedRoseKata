package com.gildedrose;

class GildedRose {

    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String ANY_OTHER_ITEM = "Any Other Item";
    public static final String CONJURED = "Conjured";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int index = 0; index < items.length; index++) {
            if (items[index].name.equals(AGED_BRIE)
                    && (items[index].quality < 50)) {
                increaseQualityOf(items[index]);
            }

            if (items[index].name.equals(BACKSTAGE_PASSES)
                    && (items[index].quality < 50)) {
                increaseQualityOf(items[index]);


                if (items[index].sellIn < 11) {
                    increaseQualityOf(items[index]);
                }

                if (items[index].sellIn < 6) {
                    increaseQualityOf(items[index]);
                }
            }

            decreaseSellInForAnyItemOtherThanSulfurus(items[index]);

            increaseQualityForAgedBrieIfSellInIsLessThan_0(items[index]);

            decreaseQualityForAnyItemOtherThanAgedBrieIfSellInIsLessThan_0(items[index]);

            if (not(items[index].name.equals(AGED_BRIE))
                    && not(items[index].name.equals(BACKSTAGE_PASSES))
                    && not(items[index].name.equals(SULFURAS_HAND_OF_RAGNAROS))
                    && not(items[index].name.equals(BACKSTAGE_PASSES))
                    && (items[index].quality > 0)) {
                items[index].quality--;
            }
        }
    }

    private void increaseQualityOf(Item item) {
        item.quality++;
    }

    private void decreaseSellInForAnyItemOtherThanSulfurus(Item item) {
        if (not(item.name.equals(SULFURAS_HAND_OF_RAGNAROS))) {
            item.sellIn--;
        }
    }

    private void increaseQualityForAgedBrieIfSellInIsLessThan_0(Item item) {
        if ((item.name.equals(AGED_BRIE))
                && (item.sellIn < 0)
                && (item.quality < 50)) {
            increaseQualityOf(item);
        }
    }

    private void decreaseQualityForAnyItemOtherThanAgedBrieIfSellInIsLessThan_0(Item item) {
        if (item.name.equals(BACKSTAGE_PASSES) && (item.sellIn < 0)) {
            item.quality = 0;
        }

        if (not(item.name.equals(AGED_BRIE))
                && (not(item.name.equals(BACKSTAGE_PASSES))
                && (not(item.name.equals(SULFURAS_HAND_OF_RAGNAROS))
                && (item.sellIn < 0)
                && (item.quality > 0)))) {
            item.quality--;
        }
    }

    private boolean not(boolean value) {
        return !value;
    }
}