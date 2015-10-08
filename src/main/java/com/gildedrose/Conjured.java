package com.gildedrose;

public class Conjured extends UpdatableItem {

    private static final int STANDARD_RATE = 2;

    public Conjured(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (item.quality > MINIMUM_QUALITY) {
            decreaseQualityBy(STANDARD_RATE);
            decreaseSellIn();
            if (item.sellIn < MINIMUM_SELL_IN_DAYS) {
                decreaseQualityBy(STANDARD_RATE);
            }
        }
    }
}
