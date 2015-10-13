package com.gildedrose;

public class ConjuredQualityUpdater extends QualityUpdater {

    protected static final int CONJURED_RATE_OF_CHANGE_OF_QUALITY = 2 * NORMAL_RATE_OF_CHANGE_OF_QUALITY;

    public ConjuredQualityUpdater(Item item) {
        super(item);
    }

    @Override
    protected void changeQuality() {
        int rate = isExpired()
                        ? 2 * CONJURED_RATE_OF_CHANGE_OF_QUALITY
                        : CONJURED_RATE_OF_CHANGE_OF_QUALITY;

        decreaseQualityBy(rate);
    }

    @Override
    protected void changeQualityAgain() {
        if (canSetQualityToMinimum()) {
            setQualityToMinimum();
        }
    }
}