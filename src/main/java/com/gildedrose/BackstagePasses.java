package com.gildedrose;

import static com.gildedrose.Quality.NORMAL_RATE_OF_CHANGE;

public class BackstagePasses extends Item {
    private static final Days TEN_DAYS = new Days(10);
    private static final Days FIVE_DAYS = new Days(5);

    public BackstagePasses(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        int rate;
        if (expiresIn(FIVE_DAYS)) {
            rate = 3 * NORMAL_RATE_OF_CHANGE;
        } else if (expiresIn(TEN_DAYS)) {
            rate = 2 * NORMAL_RATE_OF_CHANGE;
        } else {
            rate = NORMAL_RATE_OF_CHANGE;
        }
        increaseQualityBy(rate);

        decreaseSellIn();

        if (isExpired()) {
            setQualityToMinimum();
        }
    }
}