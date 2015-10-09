package com.gildedrose;

public class DefaultItem extends Product {
    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseQualityBy(1);
        decreaseSellIn();

        if (isExpired()) {
            decreaseQualityBy(1);
        }
    }
}
