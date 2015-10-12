package com.gildedrose;

public class ConjuredItem extends Product {
    private static final int CONJURED_ITEM_QUALITY_CHANGE_RATE = 2 * NORMAL_QUALITY_CHANGE_RATE;

    public ConjuredItem(Item item) {
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
                        ? 2 * CONJURED_ITEM_QUALITY_CHANGE_RATE
                        : CONJURED_ITEM_QUALITY_CHANGE_RATE;
        decreaseQualityBy(rate);
    }

    private void setQualityToZeroIfBelowZero() {
        if (canSetQualityToMinimumQuality(CONJURED_ITEM_QUALITY_CHANGE_RATE)) {
            setQualityToZero();
        }
    }
}
