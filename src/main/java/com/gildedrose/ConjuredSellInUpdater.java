package com.gildedrose;

public class ConjuredSellInUpdater implements SellInUpdater {

    @Override
    public void update(Item item) {
        if (item.sellIn > MINIMUM_QUALITY) {
            item.sellIn--;
        }
    }
}
