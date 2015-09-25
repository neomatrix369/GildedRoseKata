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
            increaseQualityForAgedBriedOrBackStagePasses(items[index]);

            decreaseQualityForAnyItemOtherThanAgedBrieOrBackStagePasses(items[index]);

            decresseSellInForAnyItemOtherThanSulfurus(items[index]);

            increaseQualityForAgedBrieIfSellInIsLessThan_0(items[index]);

            decreaseQualityForAnyItemOtherThanAgedBrieIfSellInIsLessThan_0(items[index]);
        }
    }

    private void decreaseQualityForAnyItemOtherThanAgedBrieIfSellInIsLessThan_0(Item item) {
        if (item.sellIn < 0) {
            decreaseQualityForAnyItemOtherThanAgedBrie(item);
        }
    }

    private void increaseQualityForAgedBrieIfSellInIsLessThan_0(Item item) {
        if (item.sellIn < 0) {
            increaseQualityForAgedBrie(item);
        }
    }

    private void decreaseQualityForAnyItemOtherThanAgedBrieOrBackStagePasses(Item item) {
        if (not((item.name.equals(AGED_BRIE))
                || (item.name.equals(BACKSTAGE_PASSES)))) {
            decreaseQualityIfQualityIsGreaterThanZero(item);
        }
    }

    private void increaseQualityForAgedBriedOrBackStagePasses(Item item) {
        if ((item.name.equals(AGED_BRIE))
                || (item.name.equals(BACKSTAGE_PASSES))) {
            increaseQualityIfQualityIsLessThan_50(item);
        }
    }

    private void decreaseQualityForAnyItemOtherThanAgedBrie(Item item) {
        if (not(item.name.equals(AGED_BRIE))) {
            decreaseQualityToZero(item);
            decreaseQualityIfQualityIsGreaterThanZero(item);
        }
    }

    private void increaseQualityForAgedBrie(Item item) {
        if ((item.name.equals(AGED_BRIE))) {
            increaseQualityOnlyIfQualityIsLessThan_50(item);
        }
    }

    private void decresseSellInForAnyItemOtherThanSulfurus(Item item) {
        if (not(item.name.equals(SULFURAS_HAND_OF_RAGNAROS))) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void increaseQualityIfQualityIsLessThan_50(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            increaseQualityForBackstagePasses(item);
        }
    }

    private void increaseQualityForBackstagePasses(Item item) {
        if (item.name.equals(BACKSTAGE_PASSES)) {
            increaseQualityOnlyIfSellInIsLessThan_11(item);
            increaseQualityOnlyIfSellInIsLessThan_6(item);
        }
    }

    private void increaseQualityOnlyIfSellInIsLessThan_11(Item item) {
        if (item.sellIn < 11) {
            increaseQualityOnlyIfQualityIsLessThan_50(item);
        }
    }

    private void increaseQualityOnlyIfSellInIsLessThan_6(Item item) {
        if (item.sellIn < 6) {
            increaseQualityOnlyIfQualityIsLessThan_50(item);
        }
    }

    private void increaseQualityOnlyIfQualityIsLessThan_50(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQualityToZero(Item item) {
        if (item.name.equals(BACKSTAGE_PASSES)) {
            item.quality = item.quality - item.quality;
        }
    }

    private void decreaseQualityIfQualityIsGreaterThanZero(Item item) {
        if ((not(item.name.equals(BACKSTAGE_PASSES)) && (item.quality > 0))) {
            decreaseQualityByOneForAnyItemOtherThanSulfurus(item);
        }
    }

    private void decreaseQualityByOneForAnyItemOtherThanSulfurus(Item item) {
        if (not(item.name.equals(SULFURAS_HAND_OF_RAGNAROS))) {
            item.quality = item.quality - 1;
        }
    }

    private boolean not(boolean value) {
        return !value;
    }
}