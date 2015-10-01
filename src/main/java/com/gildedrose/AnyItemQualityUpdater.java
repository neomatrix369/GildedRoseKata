package com.gildedrose;

public class AnyItemQualityUpdater implements ItemQualityUpdater {

    @Override
    public void update(Item item) {
        if (item.quality > MINIMUM_QUALITY) {
            item.quality--;

            if (item.sellIn < MINIMUM_SELL_IN) {
                item.quality = MINIMUM_QUALITY;
            }
        }
    }
}
