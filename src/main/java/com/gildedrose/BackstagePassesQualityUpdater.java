package com.gildedrose;

public class BackstagePassesQualityUpdater extends QualityUpdater {

    private static final int TEN_DAYS = 10;
    private static final int FIVE_DAYS = 5;

    public BackstagePassesQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (isExpired()) {
            setQualityToMinimum();
        } else if (canIncreaseQuality()) {
            increaseQuality();
        }
    }

    private void increaseQuality() {
        int rate;

        if (expiresIn(FIVE_DAYS)) {
            rate = 3 * NORMAL_RATE_OF_CHANGE_OF_QUALITY;
        } else if (expiresIn(TEN_DAYS)) {
            rate = 2 * NORMAL_RATE_OF_CHANGE_OF_QUALITY;
        } else {
            rate = NORMAL_RATE_OF_CHANGE_OF_QUALITY;
        }

        increaseQualityBy(rate);
    }
}