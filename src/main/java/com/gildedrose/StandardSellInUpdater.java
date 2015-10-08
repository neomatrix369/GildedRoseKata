package com.gildedrose;

public class StandardSellInUpdater implements SellInUpdater {

    @Override
    public void update(Item item) {
        if (item.quality > MINIMUM_QUALITY) {
            item.sellIn--;
        }
    }
}
