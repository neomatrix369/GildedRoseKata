package com.gildedrose;

class GildedRose {

    ItemList<Item> items;

    private ItemSellInUpdaterFactory itemSellInUpdaterFactory = new ItemSellInUpdaterFactory();
    private ItemQualityUpdaterFactory itemQualityUpdaterFactory = new ItemQualityUpdaterFactory();

    public GildedRose(ItemList items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items.asList()) {
            itemSellInUpdaterFactory
                    .getUpdaterFor(item)
                    .update(item);

            itemQualityUpdaterFactory
                    .getUpdaterFor(item)
                    .update(item);
        }
    }

    public Item firstItem() {
        return items.firstItem();
    }
}