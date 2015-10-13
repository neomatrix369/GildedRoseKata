package com.gildedrose;

public class StandardQualityUpdater extends QualityUpdater {

    public StandardQualityUpdater(Item item) {
        super(item);
    }

    @Override
    protected void changeQuality() {
        int rate = isExpired()
                        ? 2 * NORMAL_RATE_OF_CHANGE_OF_QUALITY
                        : NORMAL_RATE_OF_CHANGE_OF_QUALITY;
        decreaseQualityBy(rate);
    }

    @Override
    protected void changeQualityAgain() {}
}
