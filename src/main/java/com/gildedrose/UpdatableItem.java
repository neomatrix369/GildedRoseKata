package com.gildedrose;

public abstract class UpdatableItem {

    public abstract void update(Item item);

    public void decreaseSellInFor(Item item) { item.sellIn--; }

    public void increaseQualityOf(Item item) {
        item.quality++;
    }

    public void setQualityToZeroFor(Item item) {
        item.quality = 0;
    }

    public void decreaseQualityFor(Item item) {
        item.quality--;
    }
}
