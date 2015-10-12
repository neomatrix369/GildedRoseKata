package com.gildedrose;

public class QualityUpdaterCommand {

    public void update(Item item) {
        QualityUpdater qualityUpdater;

        switch (item.name) {
            case Constants.AGED_BRIE: {
                qualityUpdater = new AgedBrieQualityUpdater(item);
                break;
            }

            case Constants.BACKSTAGE_PASSES: {
                qualityUpdater = new BackstagePassesQualityUpdater(item);
                break;
            }

            case Constants.CONJURED: {
                qualityUpdater = new ConjuredQualityUpdater(item);
                break;
            }

            case Constants.SULFURAS: {
                qualityUpdater = new SulfurasQualityUpdater(item);
                break;
            }

            default: qualityUpdater = new StandardQualityUpdater(item);
        }

        qualityUpdater.update();
    }
}