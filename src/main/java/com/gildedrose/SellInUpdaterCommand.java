package com.gildedrose;

public class SellInUpdaterCommand {
    public void update(Item item) {
        SellInUpdater sellInUpdater;

        switch (item.name) {
            case Constants.SULFURAS: {
                sellInUpdater = new SulfurasSellInUpdater(item);
                break;
            }
            case Constants.CONJURED: {
                sellInUpdater = new ConjuredSellInUpdater(item);
                break;
            }
            default: sellInUpdater = new StandardSellInUpdater(item);
        }

        sellInUpdater.update();
    }
}