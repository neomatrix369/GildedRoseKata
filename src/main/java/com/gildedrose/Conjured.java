package com.gildedrose;

import static com.gildedrose.Quality.NORMAL_QUALITY_CHANGE_RATE;

public class Conjured extends Item {

    private static final int CONJURED_ITEM_QUALITY_CHANGE_RATE = 2 * NORMAL_QUALITY_CHANGE_RATE;

    public Conjured(String itemName, SellIn sellIn, Quality quality) {
        super(itemName, sellIn, quality);
    }

    public void update() {
        decreaseQualityBy(CONJURED_ITEM_QUALITY_CHANGE_RATE);

        decreaseSellIn();

        if (isExpired()) {
            decreaseQualityBy(CONJURED_ITEM_QUALITY_CHANGE_RATE);
        }
    }
}