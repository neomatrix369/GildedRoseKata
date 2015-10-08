package com.gildedrose;

public class AgedBrie extends UpdatableItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void changeSellIn() {
        decreaseSellIn();
        if (isExpired()) {
            decreaseSellIn();
        }
    }

    @Override
    protected void changeQuality() {
        int rate = isExpired()
                        ? 2 * NORMAL_RATE
                        : NORMAL_RATE;

        increaseQualityBy(rate);
    }
}