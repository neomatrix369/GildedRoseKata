package com.gildedrose;

public class DefaultItem extends UpdatableItem {

    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (item.quality > MINIMUM_QUALITY) {
            decreaseQualityBy(1);
            decreaseSellIn();

            if (item.sellIn < MINIMUM_SELL_IN_DAYS) {
                decreaseQualityBy(1);
                decreaseSellIn();
            }
        } 
    }
}
