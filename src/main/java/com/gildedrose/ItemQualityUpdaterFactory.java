package com.gildedrose;

public class ItemQualityUpdaterFactory {

    public ItemQualityUpdater getUpdaterFor(Item item) {
        for (ItemName itemName: ItemName.values()) {
            if (itemName.sameAs(item)) {
                return itemName.getQualityUpdater();
            }
        }
        return new AnyItemQualityUpdater();
    }
}
