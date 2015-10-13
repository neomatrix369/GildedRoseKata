package com.gildedrose;

public abstract class QualityUpdater {
    protected final Item item;
    protected int MINIMUM_QUALITY = 0;
    protected int MAXIMUM_QUALITY = 50;
    protected int MINIMUM_SELL_IN = 0;

    public QualityUpdater(Item item) {
        this.item = item;
    }

    void update() {}

    private boolean canIncreaseQuality() {
        return item.quality < MAXIMUM_QUALITY;
    }

    protected boolean isExpired() {
        return item.sellIn < MINIMUM_SELL_IN;
    }

    protected void increaseQualityBy(int by) {
        if (canIncreaseQuality()) {
            item.quality += by;
        }
    }

    protected void decreaseQualityBy(int by) {
        item.quality -= by;
    }

    protected boolean canSetQualityToMinimum() {
        return item.quality < MINIMUM_QUALITY;
    }

    protected void setQualityToMinimum() {
        item.quality = MINIMUM_QUALITY;
    }
}
