package com.gildedrose;

import static com.gildedrose.Constants.SULFURAS;
import static com.gildedrose.Constants.CONJURED;

public class SellInUpdaterCommand {
    public void update(Item item) {
        SellInUpdater sellInUpdater;

        switch (item.name) {
            case SULFURAS: {
                sellInUpdater = new SulfurasSellInUpdater(item);
                break;
            }

            case CONJURED:
            default: sellInUpdater = new StandardSellInUpdater(item);
        }

        sellInUpdater.update();
    }
}