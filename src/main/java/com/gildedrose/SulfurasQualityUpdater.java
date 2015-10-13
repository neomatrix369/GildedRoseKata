package com.gildedrose;

public class SulfurasQualityUpdater extends QualityUpdater {

    public SulfurasQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {}

    @Override
    public int rateOfChange() {
        return NO_CHANGE_TO_QUALITY;
    }
}