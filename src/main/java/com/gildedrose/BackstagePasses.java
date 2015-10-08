package com.gildedrose;

public class BackstagePasses extends UpdatableItem {

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (item.quality < MAXIMUM_QUALITY) {
            increaseQuality();


            if (item.sellIn < MINIMUM_SELL_IN_DAYS_FIRST_CUT_OFF) {
                increaseQuality();
            }

            if (item.sellIn < MINIMUM_SELL_IN_DAYS_SECOND_CUT_OFF) {
                increaseQuality();
            }

            decreaseSellIn();

            if (item.sellIn < MINIMUM_SELL_IN_DAYS) {
                setQualityToZero();
                decreaseSellIn();
            }
        }
    }
}