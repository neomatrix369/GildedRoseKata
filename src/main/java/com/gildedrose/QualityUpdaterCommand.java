package com.gildedrose;

public class QualityUpdaterCommand {

    public void update(Item item) {
        QualityUpdater qualityUpdater = new StandardQualityUpdater();

        for (ItemNameToUpdater itemNameToUpdater : ItemNameToUpdater.values()) {
            if (itemNameToUpdater.sameAs(item)) {
                qualityUpdater = itemNameToUpdater.getQualityUpdater();
                break;
            }
        }

        qualityUpdater.update(item);
    }
}
