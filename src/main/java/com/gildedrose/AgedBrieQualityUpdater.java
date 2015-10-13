package com.gildedrose;

public class AgedBrieQualityUpdater implements QualityUpdater {

    private final Item item;

    public AgedBrieQualityUpdater(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        increase(item);

        if (isExpired()) {
            increase(item);
        }
    }

    private boolean canIncreaseQuality() {
        return item.quality < MAXIMUM_QUALITY;
    }

    private boolean isExpired() {
        return item.sellIn < MINIMUM_SELL_IN;
    }

    private void increase(Item item) {
        if (canIncreaseQuality()) {
            item.quality++;
        }
    }
}