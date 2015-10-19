package com.gildedrose;

import static com.gildedrose.Quality.NORMAL_RATE_OF_CHANGE;

public class BackstagePasses extends Item {
    private static final Days TEN_DAYS = new Days(10);
    private static final Days FIVE_DAYS = new Days(5);

    public BackstagePasses(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        increaseQualityBy(getRateOfChange());

        decreaseSellIn();

        setQualityToMinimumIfItemExpires();
    }

    private void setQualityToMinimumIfItemExpires() {
        if (isExpired()) {
            setQualityToMinimum();
        }
    }

    private int getRateOfChange() {
        if (expiresIn(FIVE_DAYS)) {
            return 3 * NORMAL_RATE_OF_CHANGE;
        } else if (expiresIn(TEN_DAYS)) {
            return 2 * NORMAL_RATE_OF_CHANGE;
        } else {
            return NORMAL_RATE_OF_CHANGE;
        }
    }
}