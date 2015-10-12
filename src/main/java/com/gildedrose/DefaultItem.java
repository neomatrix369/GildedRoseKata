package com.gildedrose;

public class DefaultItem extends Product {
    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        changeQuality();

        decreaseSellIn();

        changeQualityAgain();
    }

    private void changeQuality() {
        int rate = isExpired()
                        ? 2 * NORMAL_QUALITY_CHANGE_RATE
                        : NORMAL_QUALITY_CHANGE_RATE;
        decreaseQualityBy(rate);
    }

    private void changeQualityAgain() {
        if (canSetQualityToMinimumQuality(MINIMUM_QUALITY)) {
            setQualityToZero();
        }
    }
}