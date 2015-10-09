package com.gildedrose;

public class DefaultItem extends Product {
    private final Item item;

    public DefaultItem(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        decreaseQuality(item, by(1));
        decreaseSellIn(item);

        if (isExpired(item)) {
            decreaseQuality(item, by(1));
        }
    }
}
