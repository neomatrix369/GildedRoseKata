package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();

        increaseQualityBy(getNormalRateOfChange());
    }
}