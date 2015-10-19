package com.gildedrose;

public class Conjured extends Item {

    public Conjured(String itemName, SellIn sellIn, Quality quality) {
        super(itemName, sellIn, quality);
    }

    public void update() {
        decreaseSellIn();

        decreaseQualityBy(getNormalRateOfChange());
    }

    @Override
    public int getNormalRateOfChange() {
        return 2 * super.getNormalRateOfChange();
    }
}