package com.gildedrose;

public class AgedBrie extends UpdatableItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (canIncreaseQuality()) {
            increaseQuality();
            decreaseSellIn();
        }

        if (canIncreaseQuality() && isExpired()) {
            increaseQuality();
            decreaseSellIn();
        }
    }

}
