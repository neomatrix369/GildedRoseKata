package com.gildedrose;

public class DefaultItem extends UpdatableItem {

    protected static final int QUALITY_UNIT = 1;

    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        changeQuality(item);

        changeSellIn(item);
        if (isExpired(item)) {
            changeSellIn(item);
        }
    }

    private void changeQuality(Item item) {
        if (canChangeQuality(item)) {
            decreaseQuality(item);
            if (isExpired(item)) {
                decreaseQuality(item);
            }
        }
    }
}