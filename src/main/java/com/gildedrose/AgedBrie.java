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

        if (canIncreaseQualityOf(item)
                && isExpired(item)) {
            increaseQuality();
            decreaseSellIn();
        }
    }
    
    private boolean canIncreaseQualityOf(Item item) {
        return item.quality < MAXIMUM_QUALITY;
    }

    private boolean isExpired(Item item) {
        return item.sellIn < MINIMUM_SELL_IN_DAYS;
    }
}
