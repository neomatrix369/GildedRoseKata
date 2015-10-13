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
        } else {
            increaseQualityBy(rateOfChange());
        }
    }

    @Override
    protected int rateOfChange() {
        if (expiresIn(FIVE_DAYS)) return 3 * NORMAL_RATE_OF_CHANGE_OF_QUALITY;

        if (expiresIn(TEN_DAYS)) return 2 * NORMAL_RATE_OF_CHANGE_OF_QUALITY;

        return 1 * NORMAL_RATE_OF_CHANGE_OF_QUALITY;
    }
}