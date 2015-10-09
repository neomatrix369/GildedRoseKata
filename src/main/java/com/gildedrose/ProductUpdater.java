package com.gildedrose;

public enum ProductUpdater implements Updater {
    AGED_BRIE("Aged Brie") {
        @Override
        public void update(Item item) {
            new AgedBrie(item).update();
        }
    },

    BACK_STAGE_PASSES("Backstage passes to a TAFKAL80ETC concert") {
        @Override
        public void update(Item item) {
            new BackstagePasses(item).update();
        }
    },

    CONJURED_ITEM("Conjured Item") {
        @Override
        public void update(Item item) {
            new ConjuredItem(item).update();
        }
    },

    SULFURAS("Sulfuras, Hand of Ragnaros") {
        @Override
        public void update(Item item) {
            new Sulfuras(item).update();
        }
    },

    DEFAULT_ITEM("Default Item") {
        @Override
        public void update(Item item) {
            new DefaultItem(item).update();
        }
    };

    private final String itemName;

    ProductUpdater(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }

    static void applyUpdateTo(Item item) {
        ProductUpdater itemType = ProductUpdater.getItemFor(item.name);
        itemType.update(item);
    }

    private static ProductUpdater getItemFor(String itemName) {
        for (ProductUpdater itemType : values()) {
            if (itemType.itemName.equals(itemName)) {
                return itemType;
            }
        }
        return DEFAULT_ITEM;
    }
}