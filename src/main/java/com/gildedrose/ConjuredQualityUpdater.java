package com.gildedrose;

public class ConjuredQualityUpdater implements QualityUpdater {
    @Override
    public void update(Item item) {
        item.quality += -2;

        if (item.quality < MINIMUM_QUALITY) {
            item.quality = MINIMUM_QUALITY;
        }
    }
}
