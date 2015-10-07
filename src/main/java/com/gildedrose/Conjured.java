package com.gildedrose;

public class Conjured extends UpdatableItem {

    private static final int TWICE_AS_FAST = 2;

    @Override
    public void update(Item item) {
        if (item.quality > MINIMUM_QUALITY) {
            decreaseQualityFor(item, TWICE_AS_FAST);
            decreaseSellInFor(item);
        }
    }
}
