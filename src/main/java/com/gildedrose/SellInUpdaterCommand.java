package com.gildedrose;

public class SellInUpdaterCommand {
    public void update(Item item) {
        SellInUpdater sellInUpdater;

        switch (item.name) {
            case Constants.SULFURAS: {
                sellInUpdater = new SulfurasSellInUpdater();
                break;
            }
            case Constants.CONJURED: {
                sellInUpdater = new ConjuredSellInUpdater();
                break;
            }
            default: sellInUpdater = new StandardSellInUpdater();
        }

        sellInUpdater.update(item);
    }
}