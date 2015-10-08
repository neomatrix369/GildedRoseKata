package com.gildedrose;

public class BackstagePasses extends UpdatableItem {

    protected static final int TEN_DAYS = 10;
    protected static final int FIVE_DAYS = 5;

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (canIncreaseQualityOf(item)) {
            increaseQuality();
            decreaseSellIn();

            if (itemIsDueToExpireIn(TEN_DAYS)) {
                increaseQuality();
            }

            if (itemIsDueToExpireIn(FIVE_DAYS)) {
                increaseQuality();
            }

            if (isExpired(item)) {
                setQualityToZero();
                decreaseSellIn();
            }
        }
    }
}