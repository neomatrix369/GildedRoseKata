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
        }
    },

    DEFAULT_ITEM("Default Item") {
        @Override
        public void update(Item item) {
            decreaseQuality(item, by(1));
            decreaseSellIn(item);

            if (isExpired(item)) {
                decreaseQuality(item, by(1));
            }
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

    boolean isExpired(Item item) {
        return item.sellIn < Constants.MINIMUM_SELL_IN_DAYS;
    }

    void decreaseQuality(Item item, int by) {
        if (item.quality > Constants.MINIMUM_QUALITY) {
            item.quality = item.quality - by;
        }
    }

    void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    int by(int value) {
        return value;
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

    private static class Constants {
        private static final int MINIMUM_QUALITY = 0;
        private static final int MINIMUM_SELL_IN_DAYS = 0;
    }
}