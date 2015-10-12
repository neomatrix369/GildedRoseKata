package com.gildedrose;

public class AgedBrie extends Product {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void changeQuality() {
        int rate = isExpired()
                ? 2 * NORMAL_QUALITY_CHANGE_RATE
                : NORMAL_QUALITY_CHANGE_RATE;

        increaseQualityBy(rate);
    }

    @Override
    protected void changeQualityAgain() {
        if (isExpired()) {
            increaseQualityBy(NORMAL_QUALITY_CHANGE_RATE);
        }
    }
}