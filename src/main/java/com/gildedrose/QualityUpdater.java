package com.gildedrose;

public abstract class QualityUpdater {
    protected final Item item;

    protected static final int MINIMUM_QUALITY = 0;

    protected static final int MAXIMUM_QUALITY = 50;
    protected static final int MINIMUM_SELL_IN = 0;

    protected static final int NO_CHANGE_TO_QUALITY = 0;
    protected static final int NORMAL_RATE_OF_CHANGE_OF_QUALITY = 1;

    public QualityUpdater(Item item) {
        this.item = item;
    }

    public abstract void update();
    protected abstract int rateOfChange();

    boolean isExpired() {
        return expiresIn(MINIMUM_SELL_IN);
    }

    void increaseQualityBy(int rate) {
        if (canIncreaseQuality()) {
            item.quality += rate;
        }

        if (canSetQualityToMaximum()) {
            setQualityToMaximum();
        }
    }

    void decreaseQualityBy(int rate) {
        if (canDecreaseQuality()) {
            item.quality -= rate;
        }

        if (canSetQualityToMinimum()) {
            setQualityToMinimum();
        }
    }

    private boolean canDecreaseQuality() {
        return item.quality > MINIMUM_QUALITY;
    }

    boolean canSetQualityToMinimum() {
        return item.quality < MINIMUM_QUALITY;
    }

    void setQualityToMinimum() {
        item.quality = MINIMUM_QUALITY;
    }

    protected boolean canIncreaseQuality() {
        return item.quality < MAXIMUM_QUALITY;
    }

    protected boolean expiresIn(int daysToExpiration) {
        return item.sellIn < daysToExpiration;
    }

    protected boolean canSetQualityToMaximum() {
        return item.quality > MAXIMUM_QUALITY;
    }

    protected void setQualityToMaximum() {
        item.quality = MAXIMUM_QUALITY;
    }
}