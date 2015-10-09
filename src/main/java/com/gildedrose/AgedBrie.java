package com.gildedrose;

public class AgedBrie extends UpdatableItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void changeSellIn() {
        int rate = isExpired()
                        ? 2 * NORMAL_SELL_IN_CHANGE_RATE
                        : NORMAL_SELL_IN_CHANGE_RATE;
        decreaseSellInBy(rate);
    }

    @Override
    protected void changeQuality() {
        int rate = isExpired()
                        ? 2 * NORMAL_QUALITY_CHANGE_RATE
                        : NORMAL_QUALITY_CHANGE_RATE;
        increaseQualityBy(rate);
    }
}