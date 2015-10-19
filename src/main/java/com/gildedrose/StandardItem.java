package com.gildedrose;

import static com.gildedrose.Quality.NORMAL_RATE_OF_CHANGE;

public class StandardItem extends Item {
    public StandardItem(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        decreaseSellIn();

        decreaseQualityBy(getRateOfChange());
    }

    private int getRateOfChange() {
        return isExpired()
                            ? 2 * NORMAL_RATE_OF_CHANGE
                            : NORMAL_RATE_OF_CHANGE;
    }
}