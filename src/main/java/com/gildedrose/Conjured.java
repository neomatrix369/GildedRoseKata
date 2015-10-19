package com.gildedrose;

public class Conjured extends Item {

    public Conjured(String itemName, SellIn sellIn, Quality quality) {
        super(itemName, sellIn, quality);
    }

    public void update() {
        decreaseSellIn();

        decreaseQualityBy(getRateOfChange());
    }

    @Override
    public int getRateOfChange() {
        return 2 * super.getRateOfChange();
    }
}