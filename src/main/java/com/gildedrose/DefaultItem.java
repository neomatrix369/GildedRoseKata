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
        int rate;

        if (isExpired()) {
            rate = NORMAL_RATE * 2;
        } else {
            rate = NORMAL_RATE;
        }

        decreaseQualityBy(rate);
    }
}
