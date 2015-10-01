package com.gildedrose;

public class BackstagePassesQualityUpdater implements ItemQualityUpdater {

    @Override
    public void update(Item item) {
        if (item.sellIn < MINIMUM_SELL_IN) {
            item.quality = MINIMUM_QUALITY;
        }

        if ((item.quality < MAXIMUM_QUALITY) &&
                (item.sellIn >= MINIMUM_SELL_IN)) {

            if (item.sellIn < SECOND_QUALITY_INCREASE_POINT) {
                increaseQuality(item, BY_THREE);
            } else if (item.sellIn < FIRST_QUALITY_INCREASE_POINT) {
                increaseQuality(item, BY_TWO);
            } else {
                increaseQuality(item, BY_ONE);
            }
        }
    }

    private void increaseQuality(Item item, int by) {
        item.quality += by;
    }
}