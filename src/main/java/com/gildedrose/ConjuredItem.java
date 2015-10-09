package com.gildedrose;

public class ConjuredItem extends Product {
    private static final int CONJURED_ITEM_MINIMUM_QUALITY = 2;

    private final Item item;

    public ConjuredItem(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        if (canSetQualityToMinimumQuality(item)) {
            setQualityToZero(item);
        } else {
            decreaseQuality(item, by(2));
        }
        decreaseSellIn(item);
    }

    private boolean canSetQualityToMinimumQuality(Item item) {
        return item.quality < CONJURED_ITEM_MINIMUM_QUALITY;
    }

    private void setQualityToZero(Item item) {
        item.quality = MINIMUM_QUALITY;
    }
}
