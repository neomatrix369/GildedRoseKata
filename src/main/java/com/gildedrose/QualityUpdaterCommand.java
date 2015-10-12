package com.gildedrose;

public class QualityUpdaterCommand {

    public void update(Item item) {
        QualityUpdater qualityUpdater;

        switch (item.name) {
            case Constants.AGED_BRIE: {
                qualityUpdater = new AgedBrieQualityUpdater();
                break;
            }

            case Constants.BACKSTAGE_PASSES: {
                qualityUpdater = new BackstagePassesQualityUpdater();
                break;
            }

            case Constants.CONJURED: {
                qualityUpdater = new ConjuredQualityUpdater();
                break;
            }

            case Constants.SULFURAS: {
                qualityUpdater = new SulfurasQualityUpdater();
                break;
            }

            default: qualityUpdater = new StandardQualityUpdater();
        }

        qualityUpdater.update(item);
    }
}
