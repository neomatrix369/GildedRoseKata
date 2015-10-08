package com.gildedrose;

public class DefaultItem extends UpdatableItem {

    private static final int DEFAULT_DECREASE_RATE = 1;

    public DefaultItem(Item item) {
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
        decreaseQualityBy(DEFAULT_DECREASE_RATE);

        if (isExpired()) {
            decreaseQualityBy(DEFAULT_DECREASE_RATE);
        }
    }
}
