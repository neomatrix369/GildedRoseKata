package com.gildedrose;

class GildedRose {
    protected static final String AGED_BRIE = "Aged Brie";
    protected static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    protected static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    protected static final Days ELEVEN_DAYS = new Days(11);
    protected static final Days SIX_DAYS = new Days(6);

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality(Item[] items) {
        for (Item item : items) {
            if (!item.name.equals(AGED_BRIE)
                    && !item.name.equals(BACKSTAGE_PASSES)) {
                if (item.canDecreaseQuality()) {
                    if (!item.name.equals(SULFURAS)) {
                        item.quality.decrease();
                    }
                }
            } else {
                if (item.canIncreaseQuality()) {
                    item.increaseQuality();

                    if (item.name.equals(BACKSTAGE_PASSES)) {
                        if (item.expiresIn(ELEVEN_DAYS)) {
                            if (item.canIncreaseQuality()) {
                                item.increaseQuality();
                            }
                        }

                        if (item.expiresIn(SIX_DAYS)) {
                            if (item.canIncreaseQuality()) {
                                item.increaseQuality();
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS)) {
                item.decreaseSellIn();
            }

            if (item.isExpired()) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(BACKSTAGE_PASSES)) {
                        if (item.canDecreaseQuality()) {
                            if (!item.name.equals(SULFURAS)) {
                                item.decreaseQuality();
                            }
                        }
                    } else {
                        item.setQualityToMinimum();
                    }
                } else {
                    if (item.canIncreaseQuality()) {
                        item.increaseQuality();
                    }
                }
            }
        }
    }

}