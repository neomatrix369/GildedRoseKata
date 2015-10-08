package com.gildedrose;

public class BackstagePasses extends UpdatableItem {

    protected static final int MINIMUM_SELL_IN_DAYS_FIRST_CUT_OFF = 10;
    protected static final int MINIMUM_SELL_IN_DAYS_SECOND_CUT_OFF = 5;

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (item.quality < MAXIMUM_QUALITY) {
            increaseQuality();
            decreaseSellIn();

            if (item.sellIn < MINIMUM_SELL_IN_DAYS_FIRST_CUT_OFF) {
                increaseQuality();
            }

            if (item.sellIn < MINIMUM_SELL_IN_DAYS_SECOND_CUT_OFF) {
                increaseQuality();
            }

            if (item.sellIn < MINIMUM_SELL_IN_DAYS) {
                setQualityToZero();
                decreaseSellIn();
            }
        }
    }
}