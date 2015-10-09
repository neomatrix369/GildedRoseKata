package com.gildedrose;

class BackstagePasses extends Product {

    private static final int TEN_DAYS = 10;
    private static final int FIVE_DAYS = 5;

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void changeQuality() {
        if (isExpired()) {
            resetQuality();
        } else
        if (itemIsDueToExpireIn(FIVE_DAYS)) {
            increaseQualityBy(3 * NORMAL_QUALITY_CHANGE_RATE);
        }
        else if (itemIsDueToExpireIn(TEN_DAYS)) {
            increaseQualityBy(2 * NORMAL_QUALITY_CHANGE_RATE);
        }
        else {
            increaseQualityBy(NORMAL_QUALITY_CHANGE_RATE);
        }
    }

    @Override
    protected void decreaseSellIn() {
        decreaseSellInBy(NORMAL_SELL_IN_CHANGE_RATE);
    }

    @Override
    protected void changeQualityIfExpired() {
        if (isExpired()) {
            resetQuality();
        }
    }
}