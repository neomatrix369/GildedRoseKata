package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        increaseQuality();

        decreaseSellIn();

        if (isExpired()) {
            increaseQuality();
        }
    }
}
