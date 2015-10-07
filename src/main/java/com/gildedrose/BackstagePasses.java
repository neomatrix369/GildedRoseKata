package com.gildedrose;

public class BackstagePasses extends UpdatableItem {

    @Override
    public void update(Item item) {
        if (item.quality < MAXIMUM_QUALITY) {
            increaseQualityOf(item);


            if (item.sellIn < MINIMUM_SELL_IN_DAYS_FIRST_CUT_OFF) {
                increaseQualityOf(item);
            }

            if (item.sellIn < MINIMUM_SELL_IN_DAYS_SECOND_CUT_OFF) {
                increaseQualityOf(item);
            }

            decreaseSellInFor(item);

            if (item.sellIn < MINIMUM_SELL_IN_DAYS) {
                setQualityToZeroFor(item);
                decreaseSellInFor(item);
            }
        }
    }
}