package com.gildedrose;

public class StandardQualityUpdater extends QualityUpdater {

    public StandardQualityUpdater(Item item) {
        super(item);
    }

    @Override
    protected void changeQuality() {
        decreaseQualityBy(NORMAL_RATE_OF_CHANGE_OF_QUALITY);
    }

    @Override
    protected void changeQualityAgain() {
        if (isExpired()) {
            setQualityToMinimum();
        }
    }
}
