package com.gildedrose;

public class StandardQualityUpdater implements QualityUpdater {

    private final Item item;

    public StandardQualityUpdater(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        if (item.quality > MINIMUM_QUALITY) {
            item.quality--;

            if (item.sellIn < MINIMUM_SELL_IN) {
                item.quality = MINIMUM_QUALITY;
            }
        }
    }
}
