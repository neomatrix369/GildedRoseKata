package com.gildedrose;

public class AgedBrie extends UpdatableItem {

    @Override
    public void update(Item item) {
        if (item.quality < MAXIMUM_QUALITY) {
            increaseQualityOf(item);
            decreaseSellInFor(item);

            if (item.sellIn < MINIMUM_SELL_IN_DAYS) {
                increaseQualityOf(item);
                decreaseSellInFor(item);
            }
        }
    }
}
