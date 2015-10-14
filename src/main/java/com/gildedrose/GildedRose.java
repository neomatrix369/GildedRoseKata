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
            if (AGED_BRIE.equals(item.name)) {
                updateAgedBrie(item);
            } else if (BACKSTAGE_PASSES.equals(item.name)) {
                updateBackstagePasses(item);
            } else if (SULFURAS.equals(item.name)) {
                updateSulfuras(item);
            } else {
                updateStandardItem(item);
            }
        }
    }

    private void updateAgedBrie(Item item) {
        increaseQualityOf(item);

        decreaseSellInOf(item);

        if (isExpired(item)) {
            increaseQualityOf(item);
        }
    }

    private void updateBackstagePasses(Item item) {
        increaseQualityOf(item);

        if (item.sellIn < ELEVEN_DAYS) {
            increaseQualityOf(item);
        }

        if (item.sellIn < SIX_DAYS) {
            increaseQualityOf(item);
        }

        decreaseSellInOf(item);

        if (isExpired(item)) {
            setQualityToMinimum(item);
        }
    }

    private void updateSulfuras(Item item) {
    }

    private void updateStandardItem(Item item) {
        decreaseQualityOf(item);

        decreaseSellInOf(item);

        if (isExpired(item)) {
            decreaseQualityOf(item);
        }
    }

    private void decreaseQualityOf(Item item) {
        if (item.quality > MINIMUM_QUALITY) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQualityOf(Item item) {
        if (item.quality < MAXIMUM_QUALITY) {
            item.quality = item.quality + 1;
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
}