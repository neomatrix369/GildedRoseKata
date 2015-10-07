package com.gildedrose;

public abstract class UpdatableItem {

    protected static final int MINIMUM_QUALITY = 0;
    protected static final int MINIMUM_SELL_IN_DAYS = 0;
    protected static final int MAXIMUM_QUALITY = 50;
    protected static final int MINIMUM_SELL_IN_DAYS_FIRST_CUT_OFF = 11;
    protected static final int MINIMUM_SELL_IN_DAYS_SECOND_CUT_OFF = 6;

    public abstract void update(Item item);

    public void decreaseSellInFor(Item item) { item.sellIn--; }

    public void increaseQualityOf(Item item) {
        item.quality++;
    }

    public void setQualityToZeroFor(Item item) {
        item.quality = MINIMUM_QUALITY;
    }

    public void decreaseQualityFor(Item item) {
        item.quality--;
    }
}
