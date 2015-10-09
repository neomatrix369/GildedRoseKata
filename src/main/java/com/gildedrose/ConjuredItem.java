package com.gildedrose;

public class ConjuredItem extends Product {
    private static final int CONJURED_ITEM_QUALITY_CHANGE_RATE = 2 * NORMAL_QUALITY_CHANGE_RATE;

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (canSetQualityToMinimumQuality(CONJURED_ITEM_QUALITY_CHANGE_RATE)) {
            setQualityToZero();
        } else {
            if (isExpired()) {
                decreaseQualityBy(2 * CONJURED_ITEM_QUALITY_CHANGE_RATE);
            } else {
                decreaseQualityBy(CONJURED_ITEM_QUALITY_CHANGE_RATE);
            }
        }
        decreaseSellIn();
    }
}
