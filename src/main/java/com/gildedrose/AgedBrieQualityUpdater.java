package com.gildedrose;

public class AgedBrieQualityUpdater extends QualityUpdater {

    public AgedBrieQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        increaseQualityBy(1);

        if (isExpired()) {
            increaseQualityBy(1);
        }
    }
}