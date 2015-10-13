package com.gildedrose;

import static com.gildedrose.Constants.AGED_BRIE;
import static com.gildedrose.Constants.BACKSTAGE_PASSES;
import static com.gildedrose.Constants.CONJURED;
import static com.gildedrose.Constants.SULFURAS;

public class QualityUpdaterCommand {

    public void update(Item item) {
        QualityUpdater qualityUpdater;

        switch (item.name) {
            case AGED_BRIE: {
                qualityUpdater = new AgedBrieQualityUpdater(item);
                break;
            }

            case BACKSTAGE_PASSES: {
                qualityUpdater = new BackstagePassesQualityUpdater(item);
                break;
            }

            case CONJURED: {
                qualityUpdater = new ConjuredQualityUpdater(item);
                break;
            }

            case SULFURAS: {
                qualityUpdater = new SulfurasQualityUpdater(item);
                break;
            }

            default: qualityUpdater = new StandardQualityUpdater(item);
        }

        qualityUpdater.update();
    }
}