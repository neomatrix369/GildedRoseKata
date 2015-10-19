package com.gildedrose;

import static com.gildedrose.Quality.NORMAL_RATE_OF_CHANGE;

public class Conjured extends Item {

    private static final int CONJURED_ITEM_QUALITY_CHANGE_RATE = 2 * NORMAL_RATE_OF_CHANGE;

    public Conjured(String itemName, SellIn sellIn, Quality quality) {
        super(itemName, sellIn, quality);
    }

    public void update() {
        decreaseSellIn();

        decreaseQualityBy(getRateOfChange());
    }

    @Override
    public int getRateOfChange() {
        return isExpired()
                    ? 2 * CONJURED_ITEM_QUALITY_CHANGE_RATE
                    : CONJURED_ITEM_QUALITY_CHANGE_RATE;
    }
}