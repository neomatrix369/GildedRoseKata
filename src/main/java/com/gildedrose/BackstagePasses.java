package com.gildedrose;

public class BackstagePasses extends Item {
    public BackstagePasses(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        increaseQuality();

        if (is(GildedRose.BACKSTAGE_PASSES)) {
            if (expiresIn(GildedRose.ELEVEN_DAYS)) {
                increaseQuality();
            }

            if (expiresIn(GildedRose.SIX_DAYS)) {
                increaseQuality();
            }
        }

        decreaseSellIn();

        if (isExpired()) {
            setQualityToMinimum();
        }
    }
}
