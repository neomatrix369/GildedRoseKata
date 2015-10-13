package com.gildedrose;

public class StandardQualityUpdater extends QualityUpdater {

    public StandardQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseQualityBy(1);

        if (isExpired()) {
            setQualityToMinimum();
        }
    }
}
