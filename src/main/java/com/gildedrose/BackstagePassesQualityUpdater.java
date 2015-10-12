package com.gildedrose;

public class BackstagePassesQualityUpdater implements QualityUpdater {

    private static final int FIRST_QUALITY_INCREASE_POINT = 10;
    private static final int SECOND_QUALITY_INCREASE_POINT = 5;

    private static final int BY_THREE = 3;
    private static final int BY_TWO = 2;

    private final Item item;

    public BackstagePassesQualityUpdater(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
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