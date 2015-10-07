package com.gildedrose;

public class Conjured extends UpdatableItem {

    @Override
    public void update(Item item) {
        if (item.quality > 0) {
            decreaseQualityFor(item);
            decreaseSellInFor(item);

            if (item.sellIn < 0) {
                decreaseQualityFor(item);
                decreaseSellInFor(item);
            }
        }
    }
}
