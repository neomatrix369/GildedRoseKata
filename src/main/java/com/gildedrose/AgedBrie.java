package com.gildedrose;

import static com.gildedrose.Quality.NORMAL_RATE_OF_CHANGE;

public class AgedBrie extends Item {
    public AgedBrie(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();

        int rate = isExpired()
                        ? 2 * NORMAL_RATE_OF_CHANGE
                        : NORMAL_RATE_OF_CHANGE;
        increaseQualityBy(rate);
    }
}