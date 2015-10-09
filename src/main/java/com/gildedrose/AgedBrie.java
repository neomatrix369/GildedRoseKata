package com.gildedrose;

class AgedBrie extends UpdatableItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void update() {
        changeQuality();
        changeSellIn();
        changeQualityIfExpired();
    }

    @Override
    protected void changeQualityIfExpired() {
        if (isExpired()) {
            increaseQualityBy(NORMAL_QUALITY_CHANGE_RATE);
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
        increaseQualityBy(rate);
    }
}