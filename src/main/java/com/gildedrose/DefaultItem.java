package com.gildedrose;

public class DefaultItem extends UpdatableItem {

    private static final int QUALITY_CHANGE_RATE = 1;

    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        changeQuality();

        decreaseSellIn();
        if (isExpired()) {
            decreaseSellIn();
        }
    }

    private void changeQuality() {
        if (canDecreaseQuality()) {
            decreaseQualityBy(QUALITY_CHANGE_RATE);
            if (isExpired()) {
                decreaseQualityBy(QUALITY_CHANGE_RATE);
            }
        }
    }
}
