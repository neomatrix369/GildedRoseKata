package com.gildedrose;

public class AgedBrie extends UpdatableItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (canIncreaseQualityOf(item)) {
            increaseQuality();
            decreaseSellIn();
        }

        if (canIncreaseQualityOf(item) && isExpired(item)) {
            increaseQuality();
            decreaseSellIn();
        }
    }

}
