package com.gildedrose;

public class ConjuredItem extends Product {
    private static final int CONJURED_ITEM_QUALITY_CHANGE_RATE = 2 * NORMAL_QUALITY_CHANGE_RATE;

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    protected void changeQuality() {
        int rate = isExpired()
                ? 2 * CONJURED_ITEM_QUALITY_CHANGE_RATE
                : CONJURED_ITEM_QUALITY_CHANGE_RATE;

        decreaseQualityBy(rate);
    }

    @Override
    protected void changeQualityAgain() {
        setQualityToZeroIfBelow(CONJURED_ITEM_QUALITY_CHANGE_RATE);
    }
}
