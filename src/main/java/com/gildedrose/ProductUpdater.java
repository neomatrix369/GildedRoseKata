package com.gildedrose;

public enum ProductUpdater implements Updater {
    AGED_BRIE("Aged Brie") {
        @Override
        public void update(Item item) {
            increaseQuality(item);
            decreaseSellIn(item);

            increaseQualityIfExpired(item);
        }
    },

    BACK_STAGE_PASSES("Backstage passes to a TAFKAL80ETC concert") {

        private static final int TEN_DAYS = 10;
        private static final int FIVE_DAYS = 5;

        @Override
        public void update(Item item) {
            if (canIncreaseIfItemExpiresIn(item, TEN_DAYS)) {
                increaseQuality(item);
            }

            if (canIncreaseIfItemExpiresIn(item, FIVE_DAYS)) {
                increaseQuality(item);
            }

            increaseQuality(item);
            decreaseSellIn(item);

            setQualityToZeroIfExpired(item);
        }

        private boolean canIncreaseIfItemExpiresIn(Item item, int minimumSellInDays) {
            return item.sellIn <= minimumSellInDays;
        }
    },

    CONJURED_ITEM("Conjured Item") {

        private static final int CONJURED_ITEM_MINIMUM_QUALITY = 2;

        @Override
        public void update(Item item) {
            if (canSetQualityToMinimumQuality(item)) {
                setQualityToZero(item);
            } else {
                decreaseQuality(item, by(2));
            }
            decreaseSellIn(item);
        }

        private boolean canSetQualityToMinimumQuality(Item item) {
            return item.quality < CONJURED_ITEM_MINIMUM_QUALITY;
        }

        private void setQualityToZero(Item item) {
            item.quality = Constants.MINIMUM_QUALITY;
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

    void increaseQualityIfExpired(Item item) {
        if (isExpired(item)) {
            increaseQuality(item);
        }
    }

    void setQualityToZeroIfExpired(Item item) {
        if (isExpired(item)) {
            item.quality = Constants.MINIMUM_QUALITY;
        }
    }

    void increaseQuality(Item item) {
        if (item.quality < Constants.MAXIMUM_QUALITY) {
            item.quality = item.quality + 1;
        }
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
        private static final int MAXIMUM_QUALITY = 50;
        private static final int MINIMUM_QUALITY = 0;
        private static final int MINIMUM_SELL_IN_DAYS = 0;
    }
}