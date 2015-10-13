package com.gildedrose;

public class ConjuredQualityUpdater implements QualityUpdater {

    private static final int TWO = 2;

    private final Item item;

    public ConjuredQualityUpdater(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        decreaseQualityBy(TWO);

        if (canSetQualityToMinimum()) {
            setQualityToMinimum();
        }
    }

    private void decreaseQualityBy(int by) {
        item.quality -= by;
    }

    private boolean canSetQualityToMinimum() {
        return item.quality < MINIMUM_QUALITY;
    }

    private void setQualityToMinimum() {
        item.quality = MINIMUM_QUALITY;
    }
}