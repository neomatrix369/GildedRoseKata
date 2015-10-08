package com.gildedrose;

public class BackstagePasses extends UpdatableItem {

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (item.quality < MAXIMUM_QUALITY) {
            increaseQualityOf();


            if (item.sellIn < MINIMUM_SELL_IN_DAYS_FIRST_CUT_OFF) {
                increaseQualityOf();
            }

            if (item.sellIn < MINIMUM_SELL_IN_DAYS_SECOND_CUT_OFF) {
                increaseQualityOf();
            }

            decreaseSellInFor();

            if (item.sellIn < MINIMUM_SELL_IN_DAYS) {
                setQualityToZeroFor();
                decreaseSellInFor();
            }
        }
    }
}