package com.gildedrose;

public class SellInUpdaterCommand {
    public void update(Item item) {
        SellInUpdater sellInUpdater = new StandardSellInUpdater();
        if (ItemNameToUpdater.SULFURAS.sameAs(item)) {
            sellInUpdater = new SulfurasSellInUpdater();
        } else if (ItemNameToUpdater.CONJURED_ITEM.sameAs(item)) {
            sellInUpdater = new ConjuredSellInUpdater();
        }

        sellInUpdater.update(item);
    }
}
