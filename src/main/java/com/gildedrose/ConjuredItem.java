package com.gildedrose;

public class ConjuredItem extends Product {
    private static final int CONJURED_ITEM_QUALITY_CHANGE_RATE = 2 * NORMAL_QUALITY_CHANGE_RATE;

    public ConjuredItem(Item item) {
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
                        ? 2 * CONJURED_ITEM_QUALITY_CHANGE_RATE
                        : CONJURED_ITEM_QUALITY_CHANGE_RATE;
        decreaseQualityBy(rate);
    }

    private void changeQualityAgain() {
        if (canSetQualityToMinimumQuality(CONJURED_ITEM_QUALITY_CHANGE_RATE)) {
            setQualityToZero();
        }
    }
}
