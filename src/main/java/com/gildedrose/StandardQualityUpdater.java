package com.gildedrose;

public class StandardQualityUpdater extends QualityUpdater {

    public StandardQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        changeQuality();

        changeQualityAgain();
    }

    private void changeQuality() {
        decreaseQualityBy(NORMAL_RATE_OF_CHANGE_OF_QUALITY);
    }

    private void changeQualityAgain() {
        if (isExpired()) {
            setQualityToMinimum();
        }
    }
}
