package com.gildedrose;

public class ConjuredQualityUpdater extends QualityUpdater {

    public ConjuredQualityUpdater(Item item) {
        super(item);
    }

    @Override
    protected void changeQuality() {
        decreaseQualityBy(2 * NORMAL_RATE_OF_CHANGE_OF_QUALITY);
    }

    @Override
    protected void changeQualityAgain() {
        if (canSetQualityToMinimum()) {
            setQualityToMinimum();
        }
    }
}