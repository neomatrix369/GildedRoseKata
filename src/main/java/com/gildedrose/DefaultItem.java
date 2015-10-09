package com.gildedrose;

public class DefaultItem extends Product {
    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseQualityBy(NORMAL_QUALITY_CHANGE_RATE);
        decreaseSellIn();

        if (isExpired()) {
            decreaseQualityBy(NORMAL_QUALITY_CHANGE_RATE);
        }
    }
}
