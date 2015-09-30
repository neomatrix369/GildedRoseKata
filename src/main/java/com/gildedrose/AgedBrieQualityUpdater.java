package com.gildedrose;

public class AgedBrieQualityUpdater implements ItemQualityUpdater {

    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_SELL_IN = 0;

    @Override
    public void update(Item item) {
        if (item.quality < MAXIMUM_QUALITY) {
            increase(item);

            if (item.sellIn < MINIMUM_SELL_IN) {
                increase(item);
            }
        }
    }

    private void increase(Item item) {
        item.quality++;
    }
}
