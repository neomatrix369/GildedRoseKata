package com.gildedrose;

public class AgedBrie extends Product {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();

        int rate = isExpired()
                        ? 2 * NORMAL_QUALITY_CHANGE_RATE
                        : NORMAL_QUALITY_CHANGE_RATE;

        increaseQualityBy(rate);
    }
}
