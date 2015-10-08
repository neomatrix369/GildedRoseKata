package com.gildedrose;

public class DefaultItem extends UpdatableItem {

    protected static final int QUALITY_UNIT = 1;

    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        changeQuality();

        changeSellIn();
        if (isExpired()) {
            changeSellIn();
        }
    }

    private void changeQuality() {
        if (canChangeQuality()) {
            decreaseQuality();
            if (isExpired()) {
                decreaseQuality();
            }
        }
    }
}
