package com.gildedrose;

public class ConjuredQualityUpdater extends QualityUpdater {

    public ConjuredQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        changeQuality();

        changeQualityAgain();
    }

    private void changeQuality() {
        decreaseQualityBy(2);
    }

    private void changeQualityAgain() {
        if (canSetQualityToMinimum()) {
            setQualityToMinimum();
        }
    }
}