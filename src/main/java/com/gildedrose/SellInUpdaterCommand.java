package com.gildedrose;

public class SellInUpdaterCommand {
    public void update(Item item) {
        SellInUpdater sellInUpdater =
                ItemNameToUpdater.SULFURAS.sameAs(item)
                    ? new SulfurasSellInUpdater()
                    : ItemNameToUpdater.CONJURED_ITEM.sameAs(item)
                        ? new ConjuredSellInUpdater()
                        : new StandardSellInUpdater();

        sellInUpdater.update(item);
    }
}
