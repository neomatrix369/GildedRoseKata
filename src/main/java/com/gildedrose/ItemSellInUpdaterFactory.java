package com.gildedrose;

public class ItemSellInUpdaterFactory {
    public ItemSellInUpdater getUpdaterFor(Item item) {
        if (ItemName.SULFURAS.sameAs(item)) {
            return new SulfurasSellInUpdater();
        }
        return new AnyItemSellInUpdater();
    }
}
