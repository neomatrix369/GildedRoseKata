package com.gildedrose;

public class AgedBrie extends UpdatableItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void changeQuality() {
        int rate;

        if (isExpired()) {
            rate = 2 * NORMAL_RATE;
        } else {
            rate = NORMAL_RATE;
        }

        increaseQualityBy(rate);
    }

    @Override
    protected void changeSellIn() {
        decreaseSellIn();
        if (isExpired()) {
            decreaseSellIn();
        }
    }
}
