package com.gildedrose;

public class BackstagePasses extends UpdatableItem {

    private static final int TEN_DAYS = 10;
    private static final int FIVE_DAYS = 5;

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void changeSellIn() {
        decreaseSellIn();
        if (isExpired()) {
            decreaseSellIn();
        }
    }

    @Override
    protected void changeQuality() {
        if (isExpired()) {
            resetQuality();
        }
        else if (itemIsDueToExpireIn(FIVE_DAYS)) {
            increaseQualityBy(3 * NORMAL_RATE);
        }
        else if (itemIsDueToExpireIn(TEN_DAYS)) {
            increaseQualityBy(2 * NORMAL_RATE);
        }
        else {
            increaseQualityBy(NORMAL_RATE);
        }
    }
}