package com.gildedrose;

class GildedRose {

    ItemList<Item> items;

    private ItemSellInUpdaterFactory itemSellInUpdaterFactory;
    private ItemQualityUpdaterFactory itemQualityUpdaterFactory;

    public GildedRose(ItemList items,
                      ItemSellInUpdaterFactory itemSellInUpdaterFactory,
                      ItemQualityUpdaterFactory itemQualityUpdaterFactory) {
        this.items = items;
        this.itemSellInUpdaterFactory = itemSellInUpdaterFactory;
        this.itemQualityUpdaterFactory = itemQualityUpdaterFactory;
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