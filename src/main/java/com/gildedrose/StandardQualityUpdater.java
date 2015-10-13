package com.gildedrose;

public class StandardQualityUpdater extends QualityUpdater {

    public StandardQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseQualityBy(rateOfChange());
    }

    @Override
    protected int rateOfChange() {
        return isExpired()
                    ? 2 * NORMAL_RATE_OF_CHANGE_OF_QUALITY
                    : NORMAL_RATE_OF_CHANGE_OF_QUALITY;
    }
}
