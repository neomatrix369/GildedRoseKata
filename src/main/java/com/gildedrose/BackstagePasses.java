package com.gildedrose;

public class BackstagePasses extends Item {
    private static final Days ELEVEN_DAYS = new Days(11);
    private static final Days SIX_DAYS = new Days(6);

    public BackstagePasses(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        increaseQuality();

        if (is(Product.BACKSTAGE_PASSES)) {
            if (expiresIn(ELEVEN_DAYS)) {
                increaseQuality();
            }

            if (expiresIn(SIX_DAYS)) {
                increaseQuality();
            }
        }

        decreaseSellIn();

        if (isExpired()) {
            setQualityToMinimum();
        }
    }
}
