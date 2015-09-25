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
            if (not(items[index].name.equals(AGED_BRIE))
                    && not(items[index].name.equals(BACKSTAGE_PASSES))) {
                decreaseQualityIfQualityIsGreaterThanZero(items[index]);
            } else {
                if (items[index].quality < 50) {
                    items[index].quality = items[index].quality + 1;

                    if (items[index].name.equals(BACKSTAGE_PASSES)) {
                        if (items[index].sellIn < 11) {
                            if (items[index].quality < 50) {
                                items[index].quality = items[index].quality + 1;
                            }
                        }

                        if (items[index].sellIn < 6) {
                            if (items[index].quality < 50) {
                                items[index].quality = items[index].quality + 1;
                            }
                        }
                    }
                }
            }

            if (not(items[index].name.equals(SULFURAS_HAND_OF_RAGNAROS))) {
                items[index].sellIn = items[index].sellIn - 1;
            }

            if (items[index].sellIn < 0) {
                if (not(items[index].name.equals(AGED_BRIE))) {
                    decreaseQualityToZero(items[index]);
                    decreaseQualityIfQualityIsGreaterThanZero(items[index]);
                } else {
                    if (items[index].quality < 50) {
                        items[index].quality = items[index].quality + 1;
                    }
                }
            }
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