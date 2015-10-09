package com.gildedrose;

public class BackstagePasses extends Product {
    private static final int TEN_DAYS = 10;
    private static final int FIVE_DAYS = 5;

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (canIncreaseQualityIfItemExpiresIn(TEN_DAYS)) {
            increaseQualityBy(NORMAL_QUALITY_CHANGE_RATE);
        }

        if (canIncreaseQualityIfItemExpiresIn(FIVE_DAYS)) {
            increaseQualityBy(NORMAL_QUALITY_CHANGE_RATE);
        }

        increaseQualityBy(NORMAL_QUALITY_CHANGE_RATE);
        decreaseSellIn();

        if (isExpired()) {
            setQualityToZero();
        }
    }
}
