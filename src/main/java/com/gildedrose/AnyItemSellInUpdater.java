package com.gildedrose;

public class AnyItemSellInUpdater implements ItemSellInUpdater {

    @Override
    public void update(Item item) {
        if (item.quality > 0) {
            item.sellIn--;
        }
    }
}
