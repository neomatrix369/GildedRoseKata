package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int index = 0; index < items.length; index++) {
            UpdatableItem updatableItemImpl = ItemFactory.get(items[index]);
            updatableItemImpl.update(items[index]);
        }
    }
}