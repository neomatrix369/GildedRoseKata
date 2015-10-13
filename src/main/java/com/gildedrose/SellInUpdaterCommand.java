package com.gildedrose;

public class SellInUpdaterCommand {
    public void update(Item item) {
        SellInUpdater sellInUpdater;

        switch (item.name) {
            case Constants.SULFURAS: {
                sellInUpdater = new SulfurasSellInUpdater(item);
                break;
            }

            case Constants.CONJURED:
            default: sellInUpdater = new StandardSellInUpdater(item);
        }

        sellInUpdater.update();
    }
}