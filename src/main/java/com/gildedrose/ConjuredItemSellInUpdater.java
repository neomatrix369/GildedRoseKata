package com.gildedrose;

public class ConjuredItemSellInUpdater implements ItemSellInUpdater {
    @Override
    public void update(Item item) {
        if (item.sellIn > MINIMUM_QUALITY) {
            item.sellIn--;
        }
    }
}
