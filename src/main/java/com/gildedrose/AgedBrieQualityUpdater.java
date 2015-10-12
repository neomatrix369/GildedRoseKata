package com.gildedrose;

public class AgedBrieQualityUpdater implements QualityUpdater {

    @Override
    public void update(Item item) {
        if (item.quality < MAXIMUM_QUALITY) {
            increase(item);

            if (item.sellIn < MINIMUM_SELL_IN) {
                increase(item);
            }
        }

        if (item.quality > MAXIMUM_QUALITY) {
            item.quality = MAXIMUM_QUALITY;
        }
    }

    private void increase(Item item) {
        item.quality++;
    }
}
