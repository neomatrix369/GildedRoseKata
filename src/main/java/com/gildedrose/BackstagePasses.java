package com.gildedrose;

public class BackstagePasses extends Product {
    private final Item item;

    public BackstagePasses(Item item) {
        this.item = item;
    }

    private static final int TEN_DAYS = 10;
    private static final int FIVE_DAYS = 5;

    @Override
    public void update() {
        if (canIncreaseIfItemExpiresIn(item, TEN_DAYS)) {
            increaseQuality(item);
        }

        if (canIncreaseIfItemExpiresIn(item, FIVE_DAYS)) {
            increaseQuality(item);
        }

        increaseQuality(item);
        decreaseSellIn(item);

        setQualityToZeroIfExpired(item);
    }

    private boolean canIncreaseIfItemExpiresIn(Item item, int minimumSellInDays) {
        return item.sellIn <= minimumSellInDays;
    }
}
