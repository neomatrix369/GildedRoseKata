package com.gildedrose;

public class Conjured extends UpdatableItem {

    private static final int TWICE_AS_FAST = 2;

    public Conjured(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (item.quality > MINIMUM_QUALITY) {
            decreaseQualityFor(TWICE_AS_FAST);
            decreaseSellInFor();
        }
    }
}
