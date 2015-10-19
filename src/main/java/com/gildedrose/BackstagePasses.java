package com.gildedrose;

public class BackstagePasses extends Item {
    private static final int ELEVEN_DAYS = 11;
    private static final int SIX_DAYS = 6;

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        increaseQuality();

        if (sellIn < ELEVEN_DAYS) {
            increaseQuality();
        }

        if (sellIn < SIX_DAYS) {
            increaseQuality();
        }

        decreaseSellIn();

        if (isExpired()) {
            setQualityToMinimum();
        }
    }
}
