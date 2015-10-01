package com.gildedrose;

public class AnyItemSellInUpdater implements ItemSellInUpdater {

    @Override
    public void update(Item item) {
        if (item.quality > MINIMUM_QUALITY) {
            item.sellIn--;
        }
    }
}
