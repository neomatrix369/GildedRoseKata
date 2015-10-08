package com.gildedrose;

public class AgedBrie extends UpdatableItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (canIncreaseQualityOf()) {
            increaseQuality();
            decreaseSellIn();
        }

        if (canIncreaseQualityOf() && isExpired()) {
            increaseQuality();
            decreaseSellIn();
        }
    }

}
