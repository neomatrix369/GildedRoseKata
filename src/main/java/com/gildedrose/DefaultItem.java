package com.gildedrose;

public class DefaultItem extends Product {
    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    protected void changeQuality() {
        int rate = isExpired()
                ? 2 * NORMAL_QUALITY_CHANGE_RATE
                : NORMAL_QUALITY_CHANGE_RATE;

        decreaseQualityBy(rate);
    }

    @Override
    protected void changeQualityAgain() {
        setQualityToZeroIfBelow(MINIMUM_QUALITY);
    }
}