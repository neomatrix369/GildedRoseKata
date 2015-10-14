package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;

    private static final int ZERO_DAYS = 0;
    private static final int SIX_DAYS = 6;
    private static final int ELEVEN_DAYS = 11;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (AGED_BRIE.equals(item.name)
                    || BACKSTAGE_PASSES.equals(item.name)) {
                if (item.quality < MAXIMUM_QUALITY) {
                    increaseQualityOf(item);

                    if (BACKSTAGE_PASSES.equals(item.name)) {
                        if (item.sellIn < ELEVEN_DAYS) {
                            if (item.quality < MAXIMUM_QUALITY) {
                                increaseQualityOf(item);
                            }
                        }

                        if (item.sellIn < SIX_DAYS) {
                            if (item.quality < MAXIMUM_QUALITY) {
                                increaseQualityOf(item);
                            }
                        }
                    }
                }
            } else {
                if (item.quality > MINIMUM_QUALITY) {
                    if (SULFURAS.equals(item.name)) {

                    } else {
                        decreaseQualityOf(item);
                    }
                }
            }

            if (SULFURAS.equals(item.name)) {

            } else {
                decreaseSellInOf(item);
            }

            if (isExpired(item)) {
                if (AGED_BRIE.equals(item.name)) {
                    if (item.quality < MAXIMUM_QUALITY) {
                        increaseQualityOf(item);
                    }
                } else {
                    if (BACKSTAGE_PASSES.equals(item.name)) {
                        setQualityToMinimum(item);
                    } else {
                        if (item.quality > MINIMUM_QUALITY) {
                            if (SULFURAS.equals(item.name)) {
                                continue;
                            }
                            decreaseQualityOf(item);
                        }
                    }
                }
            }
        }
    }

    private boolean isExpired(Item item) {
        return item.sellIn < ZERO_DAYS;
    }

    private void decreaseSellInOf(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void setQualityToMinimum(Item item) {
        item.quality = MINIMUM_QUALITY;
    }

    private void decreaseQualityOf(Item item) {
        item.quality = item.quality - 1;
    }

    private void increaseQualityOf(Item item) {
        item.quality = item.quality + 1;
    }
}