package com.gildedrose;

public class DefaultItem extends UpdatableItem {

    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (item.quality > MINIMUM_QUALITY) {
            decreaseQualityFor(1);
            decreaseSellInFor();

            if (item.sellIn < MINIMUM_SELL_IN_DAYS) {
                decreaseQualityFor(1);
                decreaseSellInFor();
            }
        } 
    }
}
