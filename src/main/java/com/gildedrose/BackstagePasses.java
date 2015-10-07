package com.gildedrose;

public class BackstagePasses extends UpdatableItem {

    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            increaseQualityOf(item);


            if (item.sellIn < 11) {
                increaseQualityOf(item);
            }

            if (item.sellIn < 6) {
                increaseQualityOf(item);
            }

            decreaseSellInFor(item);

            if (item.sellIn < 0) {
                setQualityToZeroFor(item);
                decreaseSellInFor(item);
            }
        }
    }
}