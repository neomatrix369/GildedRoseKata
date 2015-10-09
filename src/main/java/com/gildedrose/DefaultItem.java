package com.gildedrose;

class DefaultItem extends UpdatableItem {

    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    protected void update() {
        changeQuality();
        changeSellIn();
        changeQualityIfExpired();
    }

    protected void changeQualityIfExpired() {
        if (isExpired()) {
            decreaseQualityBy(NORMAL_QUALITY_CHANGE_RATE);
        }
    }

    @Override
    protected void changeSellIn() {
        decreaseSellInBy(NORMAL_SELL_IN_CHANGE_RATE);
    }

    @Override
    protected void changeQuality() {
        final int rate = isExpired()
                        ? 2 * NORMAL_QUALITY_CHANGE_RATE
                        : NORMAL_QUALITY_CHANGE_RATE;
        decreaseQualityBy(rate);
    }
}