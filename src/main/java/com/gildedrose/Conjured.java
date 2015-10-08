package com.gildedrose;

public class Conjured extends UpdatableItem {

    private static final int CONJURED_RATE = 2 * NORMAL_RATE;

    public Conjured(Item item) {
        super(item);
    }

    @Override
    protected void changeSellIn() {
        decreaseSellIn();
    }

    @Override
    protected void changeQuality() {
        int rate = isExpired()
                        ? 2 * CONJURED_RATE
                        : CONJURED_RATE;

        decreaseQualityBy(rate);
    }
}