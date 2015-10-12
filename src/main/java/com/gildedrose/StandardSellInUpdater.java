package com.gildedrose;

public class StandardSellInUpdater implements SellInUpdater {

    private final Item item;

    public StandardSellInUpdater(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        if (item.quality > MINIMUM_QUALITY) {
            item.sellIn--;
        }
    }
}
