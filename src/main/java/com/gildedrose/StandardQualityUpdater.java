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
        decreaseQualityBy(1);
    }

    private void changeQualityAgain() {
        if (isExpired()) {
            setQualityToMinimum();
        }
    }
}
