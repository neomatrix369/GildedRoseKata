package com.gildedrose;

public class BackstagePassesQualityUpdater extends QualityUpdater {

    private static final int TEN_DAYS = 10;
    private static final int FIVE_DAYS = 5;

    public BackstagePassesQualityUpdater(Item item) {
        super(item);
    }

    @Override
    protected void changeQuality() {
        if (canIncreaseQuality()) {
            if (expiresIn(FIVE_DAYS)) {
                increaseQualityBy(3 * NORMAL_RATE_OF_CHANGE_OF_QUALITY);
            } else if (expiresIn(TEN_DAYS)) {
                increaseQualityBy(2 * NORMAL_RATE_OF_CHANGE_OF_QUALITY);
            } else {
                increaseQualityBy(NORMAL_RATE_OF_CHANGE_OF_QUALITY);
            }
        }
    }

    @Override
    protected void changeQualityAgain() {
        if (isExpired()) {
            setQualityToMinimum();
        }
    }
}