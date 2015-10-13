package com.gildedrose;

public class StandardQualityUpdater extends QualityUpdater {

    public StandardQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (canDecreaseQuality()) {
            decreaseQualityBy(1);

            if (isExpired()) {
                setQualityToMinimum();
            }
        }
    }

    private boolean canDecreaseQuality() {
        return item.quality > MINIMUM_QUALITY;
    }
}
