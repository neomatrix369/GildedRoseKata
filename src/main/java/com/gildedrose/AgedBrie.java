package com.gildedrose;

public class AgedBrie extends ItemType {

    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            increaseQualityOf(item);
            decreaseSellInFor(item);

            if (item.sellIn < 0) {
                increaseQualityOf(item);
                decreaseSellInFor(item);
            }
        }
    }
}
