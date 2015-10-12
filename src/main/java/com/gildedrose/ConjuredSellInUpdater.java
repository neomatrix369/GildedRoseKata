package com.gildedrose;

public class ConjuredSellInUpdater implements SellInUpdater {

    private final Item item;

    public ConjuredSellInUpdater(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        if (item.sellIn > MINIMUM_QUALITY) {
            item.sellIn--;
        }
    }
}
