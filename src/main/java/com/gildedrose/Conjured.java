package com.gildedrose;

public class Conjured extends UpdatableItem {

    private static final int CONJURED_DECREASE_RATE = 2;

    public Conjured(Item item) {
        super(item);
    }

    @Override
    protected void changeSellIn() {
        decreaseSellIn();
    }

    @Override
    protected void changeQuality() {
        decreaseQualityBy(CONJURED_DECREASE_RATE);
        if (isExpired()) {
            decreaseQualityBy(CONJURED_DECREASE_RATE);
        }
    }
}
