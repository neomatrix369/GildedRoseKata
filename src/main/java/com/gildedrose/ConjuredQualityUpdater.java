package com.gildedrose;

public class ConjuredQualityUpdater implements QualityUpdater {

    private static final int DECREASE_BY_TWO = -2;

    private final Item item;

    public ConjuredQualityUpdater(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.quality += DECREASE_BY_TWO;

        if (item.quality < MINIMUM_QUALITY) {
            item.quality = MINIMUM_QUALITY;
        }
    }
}
