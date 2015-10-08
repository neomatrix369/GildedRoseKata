package com.gildedrose;

public abstract class UpdatableItem {

    protected static final int MINIMUM_QUALITY = 0;
    protected static final int MINIMUM_SELL_IN_DAYS = 0;
    protected static final int MAXIMUM_QUALITY = 50;
    protected static final int MINIMUM_SELL_IN_DAYS_FIRST_CUT_OFF = 11;
    protected static final int MINIMUM_SELL_IN_DAYS_SECOND_CUT_OFF = 6;

    protected final Item item;

    public UpdatableItem(Item item) {
        this.item = item;
    }

    public abstract void update();

    public void decreaseSellInFor() { item.sellIn--; }

    public void increaseQualityOf() {
        item.quality++;
    }

    public void setQualityToZeroFor() {
        item.quality = MINIMUM_QUALITY;
    }

    public void decreaseQualityFor(int by) {
        item.quality -= by;
    }
}
