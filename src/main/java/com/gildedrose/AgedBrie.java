package com.gildedrose;

public class AgedBrie extends UpdatableItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void update() {
        increaseQuality();

        decreaseSellIn();

        if (isExpired()) {
            increaseQuality();
            decreaseSellIn();
        }
    }
}
