package com.gildedrose;

public class AnyItemQualityUpdater implements ItemQualityUpdater {
    @Override
    public void update(Item item) {
        if (item.quality > 0) {
            item.quality--;

            if (item.sellIn < 0) {
                item.quality = 0;
            }
        }
    }
}
