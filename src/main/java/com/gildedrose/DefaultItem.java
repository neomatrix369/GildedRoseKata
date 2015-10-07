package com.gildedrose;

public class DefaultItem extends UpdatableItem {

    @Override
    public void update(Item item) {
        if (item.quality > MINIMUM_QUALITY) {
            decreaseQualityFor(item, 1);
            decreaseSellInFor(item);

            if (item.sellIn < MINIMUM_SELL_IN_DAYS) {
                decreaseQualityFor(item, 1);
                decreaseSellInFor(item);
            }
        } 
    }
}
