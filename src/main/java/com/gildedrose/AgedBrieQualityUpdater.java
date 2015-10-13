package com.gildedrose;

public class AgedBrieQualityUpdater extends QualityUpdater {

    public AgedBrieQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        increaseQualityBy(rateOfChange());
    }

    @Override
    public int rateOfChange() {
        return isExpired()
                    ? 2 * NORMAL_RATE_OF_CHANGE_OF_QUALITY
                    : NORMAL_RATE_OF_CHANGE_OF_QUALITY;
    }
}