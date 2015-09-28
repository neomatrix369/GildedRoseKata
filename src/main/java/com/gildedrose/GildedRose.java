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
                decreaseSellInFor(items[index]);

                if (items[index].sellIn < 0) {
                    increaseQualityOf(items[index]);
                    decreaseSellInFor(items[index]);
                }
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

                decreaseSellInFor(items[index]);
            }

            if (items[index].name.equals(BACKSTAGE_PASSES)
                    && (items[index].sellIn < 0)) {
                setQualityToZero(items[index]);
                decreaseSellInFor(items[index]);
            }

            if (not(items[index].name.equals(AGED_BRIE))
                    && not(items[index].name.equals(BACKSTAGE_PASSES))
                    && not(items[index].name.equals(SULFURAS_HAND_OF_RAGNAROS))
                    && not(items[index].name.equals(BACKSTAGE_PASSES))
                    && (items[index].quality > 0)) {
                decreaseQualityFor(items[index]);
                decreaseSellInFor(items[index]);

                if (items[index].sellIn < 0) {
                    decreaseQualityFor(items[index]);
                    decreaseSellInFor(items[index]);
                }
            }
        }
    }

    private void setQualityToZero(Item item) {
        item.quality = 0;
    }

    private void decreaseQualityFor(Item item) {
        item.quality--;
    }

    private void decreaseSellInFor(Item item) {
        item.sellIn--;
    }

    private void increaseQualityOf(Item item) {
        item.quality++;
    }

    private boolean not(boolean value) {
        return !value;
    }
}