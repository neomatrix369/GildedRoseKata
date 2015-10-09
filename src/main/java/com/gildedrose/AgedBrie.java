package com.gildedrose;

public class AgedBrie extends Product {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void update() {
        increaseQuality();
        decreaseSellIn();

        increaseQualityIfExpired();
    }
}
