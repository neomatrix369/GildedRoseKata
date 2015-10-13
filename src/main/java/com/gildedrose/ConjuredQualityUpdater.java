package com.gildedrose;

public class ConjuredQualityUpdater extends QualityUpdater {

    public ConjuredQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseQualityBy(2);

        if (canSetQualityToMinimum()) {
            setQualityToMinimum();
        }
    }
}