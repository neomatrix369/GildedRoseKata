package com.gildedrose;

public class Conjured extends UpdatableItem {

    private static final int STANDARD_RATE = 2;

    public Conjured(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (canChangeQuality(item)) {
            decreaseQualityBy(STANDARD_RATE);
            decreaseSellIn();
            if (isExpired(item)) {
                decreaseQualityBy(STANDARD_RATE);
            }
        }
    }
}