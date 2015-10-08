package com.gildedrose;

public class DefaultItem extends UpdatableItem {

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
        int rate = isExpired()
                        ? 2 * NORMAL_RATE
                        : NORMAL_RATE;

        decreaseQualityBy(rate);
    }
}