package com.gildedrose;

public class DefaultItem extends Product {
    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();

        int rate = isExpired()
                        ? 2 * NORMAL_QUALITY_CHANGE_RATE
                        : NORMAL_QUALITY_CHANGE_RATE;
        decreaseQualityBy(rate);

        if (canSetQualityToMinimumQuality(MINIMUM_QUALITY)) {
            setQualityToZero();
        }
    }
}