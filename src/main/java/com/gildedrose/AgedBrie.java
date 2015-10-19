package com.gildedrose;

import static com.gildedrose.Quality.NORMAL_QUALITY_CHANGE_RATE;

public class AgedBrie extends Item {
    public AgedBrie(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();

        int rate = isExpired()
                        ? 2 * NORMAL_QUALITY_CHANGE_RATE
                        : NORMAL_QUALITY_CHANGE_RATE;
        increaseQualityBy(rate);
    }
}