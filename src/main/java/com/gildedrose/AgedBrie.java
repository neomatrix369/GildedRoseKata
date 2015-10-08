package com.gildedrose;

public class AgedBrie extends UpdatableItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (item.quality < MAXIMUM_QUALITY) {
            increaseQualityOf();
            decreaseSellInFor();

            if (item.sellIn < MINIMUM_SELL_IN_DAYS) {
                increaseQualityOf();
                decreaseSellInFor();
            }
        }
    }
}
