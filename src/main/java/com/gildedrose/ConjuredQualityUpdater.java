package com.gildedrose;

public class ConjuredQualityUpdater implements QualityUpdater {

    private static final int DECREASE_BY_TWO = -2;

    @Override
    public void update(Item item) {
        item.quality += DECREASE_BY_TWO;

        if (item.quality < MINIMUM_QUALITY) {
            item.quality = MINIMUM_QUALITY;
        }
    }
}
