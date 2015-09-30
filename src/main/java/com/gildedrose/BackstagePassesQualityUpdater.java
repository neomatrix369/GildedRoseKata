package com.gildedrose;

public class BackstagePassesQualityUpdater implements ItemQualityUpdater {
    @Override
    public void update(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.quality < 50) {
            item.quality++;

            if (item.sellIn < 10) {
                item.quality++;
            }

            if (item.sellIn < 5) {
                item.quality++;
            }
        }
    }
}
