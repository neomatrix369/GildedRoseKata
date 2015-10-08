package com.gildedrose;

class GildedRose {

    ItemList<Item> items;

    private SellInUpdaterCommand sellInUpdaterCommand;
    private QualityUpdaterCommand qualityUpdaterCommand;

    public GildedRose(ItemList items,
                      SellInUpdaterCommand sellInUpdaterCommand,
                      QualityUpdaterCommand qualityUpdaterCommand) {
        this.items = items;
        this.sellInUpdaterCommand = sellInUpdaterCommand;
        this.qualityUpdaterCommand = qualityUpdaterCommand;
    }

    public void updateQuality() {
        for (Item item : items.asList()) {
            sellInUpdaterCommand.update(item);
            qualityUpdaterCommand.update(item);
        }
    }

    public Item firstItem() {
        return items.firstItem();
    }
}