package com.gildedrose;

public class BackstagePasses extends Product {
    private static final int TEN_DAYS = 10;
    private static final int FIVE_DAYS = 5;

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void update() {
        changeQuality();

        decreaseSellIn();

        changeQualityAgain();
    }

    private void changeQuality() {
        if (canIncreaseQualityIfItemExpiresIn(FIVE_DAYS)) {
            increaseQualityBy(3 * NORMAL_QUALITY_CHANGE_RATE);
        } else if (canIncreaseQualityIfItemExpiresIn(TEN_DAYS)) {
            increaseQualityBy(2 * NORMAL_QUALITY_CHANGE_RATE);
        } else {
            increaseQualityBy(NORMAL_QUALITY_CHANGE_RATE);
        }
    }

    private void changeQualityAgain() {
        if (isExpired()) {
            setQualityToZero();
        }
    }
}
