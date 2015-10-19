package com.gildedrose;

import static com.gildedrose.Quality.NORMAL_QUALITY_CHANGE_RATE;

public class Conjured extends Item {

    public Conjured(String itemName, SellIn sellIn, Quality quality) {
        super(itemName, sellIn, quality);
    }

    public void update() {
        decreaseQualityBy(2 * NORMAL_QUALITY_CHANGE_RATE);

        decreaseSellIn();
    }
}
