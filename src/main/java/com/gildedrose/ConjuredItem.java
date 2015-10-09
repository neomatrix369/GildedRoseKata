package com.gildedrose;

public class ConjuredItem extends Product {
    private static final int CONJURED_ITEM_MINIMUM_QUALITY = 2;

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (canSetQualityToMinimumQuality(CONJURED_ITEM_MINIMUM_QUALITY)) {
            setQualityToZero();
        } else {
            if (isExpired()) {
                decreaseQualityBy(2 * CONJURED_ITEM_MINIMUM_QUALITY);
            } else {
                decreaseQualityBy(CONJURED_ITEM_MINIMUM_QUALITY);
            }
        }
        decreaseSellIn();
    }
}
