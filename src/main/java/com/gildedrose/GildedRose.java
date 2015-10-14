package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (AGED_BRIE.equals(item.name)
                    || BACKSTAGE_PASSES.equals(item.name)) {
                if (item.quality < 50) {
                    increaseQualityOf(item);

                    if (BACKSTAGE_PASSES.equals(item.name)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                increaseQualityOf(item);
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                increaseQualityOf(item);
                            }
                        }
                    }
                }
            } else {
                if (item.quality > 0) {
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

            if (item.sellIn < 0) {
                if (AGED_BRIE.equals(item.name)) {
                    if (item.quality < 50) {
                        increaseQualityOf(item);
                    }
                } else {
                    if (BACKSTAGE_PASSES.equals(item.name)) {
                        setQualityToZero(item);
                    } else {
                        if (item.quality > 0) {
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

    private void decreaseSellInOf(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void setQualityToZero(Item item) {
        item.quality = 0;
    }

    private void decreaseQualityOf(Item item) {
        item.quality = item.quality - 1;
    }

    private void increaseQualityOf(Item item) {
        item.quality = item.quality + 1;
    }
}