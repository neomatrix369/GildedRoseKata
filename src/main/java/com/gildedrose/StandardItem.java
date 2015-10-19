package com.gildedrose;

public class StandardItem extends Item {
    public StandardItem(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        decreaseQuality();

        decreaseSellIn();

        if (isExpired()) {
            decreaseQuality();
        }
    }
}