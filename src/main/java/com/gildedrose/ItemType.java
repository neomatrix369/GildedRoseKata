package com.gildedrose;

public class ItemType {
    public void update(Item item) {
    }

    protected void decreaseSellInFor(Item item) {
        item.sellIn--;
    }

    protected void increaseQualityOf(Item item) {
        item.quality++;
    }

    protected void setQualityToZero(Item item) {
        item.quality = 0;
    }

    protected void decreaseQualityFor(Item item) {
        item.quality--;
    }
}
