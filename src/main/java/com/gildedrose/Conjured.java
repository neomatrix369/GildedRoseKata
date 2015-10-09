package com.gildedrose;

class Conjured extends UpdatableItem {

    private static final int CONJURED_RATE = 2 * NORMAL_QUALITY_CHANGE_RATE;

    public Conjured(Item item) {
        super(item);
    }

    @Override
    protected void changeQualityIfExpired() {
        if (isExpired()) {
            decreaseQualityBy(CONJURED_RATE);
        }
    }

    @Override
    protected void changeSellIn() {
        decreaseSellInBy(NORMAL_SELL_IN_CHANGE_RATE);
    }

    @Override
    protected void changeQuality() {
        final int rate = isExpired()
                        ? 2 * CONJURED_RATE
                        : CONJURED_RATE;
        decreaseQualityBy(rate);
    }
}