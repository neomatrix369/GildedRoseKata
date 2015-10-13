package com.gildedrose;

public class AgedBrieQualityUpdater extends QualityUpdater {

    public AgedBrieQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        increaseQuality();

        setQualityToMaximum();
    }

    private void increaseQuality() {
        int rate = isExpired()
                        ? 2
                        : 1;
        increaseQualityBy(rate);
    }

    private boolean qualityIsMoreThanMaximum() {
        return item.quality > MAXIMUM_QUALITY;
    }

    private void setQualityToMaximum() {
        if (qualityIsMoreThanMaximum()) {
            item.quality = MAXIMUM_QUALITY;
        }
    }
}