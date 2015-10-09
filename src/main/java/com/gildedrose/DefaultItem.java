package com.gildedrose;

class DefaultItem extends Product {

    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    protected void changeQuality() {
        final int rate = isExpired()
                        ? 2 * NORMAL_QUALITY_CHANGE_RATE
                        : NORMAL_QUALITY_CHANGE_RATE;
        decreaseQualityBy(rate);
    }

    @Override
    protected void decreaseSellIn() {
        decreaseSellInBy(NORMAL_SELL_IN_CHANGE_RATE);
    }

    protected void changeQualityIfExpired() {
        if (isExpired()) {
            decreaseQualityBy(NORMAL_QUALITY_CHANGE_RATE);
        }
    }
}