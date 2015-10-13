package com.gildedrose;

public class AgedBrieQualityUpdater extends QualityUpdater {

    public AgedBrieQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        changeQuality();

        changeQualityAgain();
    }

    private void changeQuality() {
        int rate = isExpired()
                        ? 2
                        : 1;
        increaseQualityBy(rate);
    }

    private void changeQualityAgain() {
        if (qualityIsMoreThanMaximum()) {
            item.quality = MAXIMUM_QUALITY;
        }
    }
}