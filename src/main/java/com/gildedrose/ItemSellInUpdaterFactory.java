package com.gildedrose;

public class ItemSellInUpdaterFactory {
    public ItemSellInUpdater getUpdaterFor(Item item) {
        if (ItemName.SULFURAS.sameAs(item)) {
            return new SulfurasSellInUpdater();
        } else if (ItemName.CONJURED_ITEM.sameAs(item)) {
            return new ConjuredItemSellInUpdater();
        }
        return new AnyItemSellInUpdater();
    }
}
