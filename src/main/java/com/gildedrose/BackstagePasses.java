package com.gildedrose;

public class BackstagePasses extends ItemType {

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
                setQualityToZero(item);
                decreaseSellInFor(item);
            }
        }
    }
}