package com.gildedrose;

public class StandardSellInUpdater extends SellInUpdater {

    private final Item item;

    public StandardSellInUpdater(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn--;
    }
}
