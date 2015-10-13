package com.gildedrose;

public class BackstagePassesQualityUpdater extends QualityUpdater {

    private static final int TEN_DAYS = 10;
    private static final int FIVE_DAYS = 5;

    public BackstagePassesQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        changeQuality();

        changeQualityAgain();
    }

    private void changeQuality() {
        if (canIncreaseQuality()) {
            if (expiresIn(FIVE_DAYS)) {
                increaseQualityBy(3);
            } else if (expiresIn(TEN_DAYS)) {
                increaseQualityBy(2);
            } else {
                increaseQualityBy(1);
            }
        }
    }

    private void changeQualityAgain() {
        if (isExpired()) {
            setQualityToMinimum();
        }
    }
}