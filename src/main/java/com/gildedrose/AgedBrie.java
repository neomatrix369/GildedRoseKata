package com.gildedrose;

public class AgedBrie extends Product {

    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        increaseQuality(item);
        decreaseSellIn(item);

        increaseQualityIfExpired(item);
    }
}
