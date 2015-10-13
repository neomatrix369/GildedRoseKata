package com.gildedrose;

public class AgedBrieQualityUpdater extends QualityUpdater {

    public AgedBrieQualityUpdater(Item item) {
        super(item);
    }

    @Override
    protected void changeQuality() {
        int rate = isExpired()
                        ? 2 * NORMAL_RATE_OF_CHANGE_OF_QUALITY
                        : NORMAL_RATE_OF_CHANGE_OF_QUALITY;
        increaseQualityBy(rate);
    }

    @Override
    protected void changeQualityAgain() {
        if (qualityIsMoreThanMaximum()) {
            setQualityToMaximum();
        }
    }
}