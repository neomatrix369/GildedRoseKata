package com.gildedrose;

public class Conjured extends UpdatableItem {

    private static final int STANDARD_RATE = 2;

    public Conjured(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (canChangeQuality()) {
            decreaseQualityBy(STANDARD_RATE);
            decreaseSellIn();
            if (isExpired()) {
                decreaseQualityBy(STANDARD_RATE);
            }
        }
    }
}
