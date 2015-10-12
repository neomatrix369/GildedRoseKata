package com.gildedrose;

public class DefaultItem extends Product {
    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();

        decreaseQuality();

        setQualityToZeroIfBelowZero();
    }

    private void decreaseQuality() {
        int rate = isExpired()
                        ? 2 * NORMAL_QUALITY_CHANGE_RATE
                        : NORMAL_QUALITY_CHANGE_RATE;
        decreaseQualityBy(rate);
    }

    private void setQualityToZeroIfBelowZero() {
        if (canSetQualityToMinimumQuality(MINIMUM_QUALITY)) {
            setQualityToZero();
        }
    }
}