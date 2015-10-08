package com.gildedrose;

public enum ItemUpdater implements UpdatableItem {
    AGED_BRIE("Aged Brie") {
        @Override
        public void update(Item item) {
            if (item.quality < Constants.MAXIMUM_QUALITY) {
                increaseQuality(item);
                decreaseSellIn(item);

                increaseQualityIfItemHasPastSellInDate(item);
            }
        }
    },

    BACK_STAGE_PASSES("Backstage passes to a TAFKAL80ETC concert") {

        private static final int FIRST_MINIMUM_SELL_IN_DAYS = 11;
        private static final int SECOND_MINIMUM_SELL_IN_DAYS = 6;

        @Override
        public void update(Item item) {
            if ((item.sellIn < FIRST_MINIMUM_SELL_IN_DAYS)
                    && (item.quality < Constants.MAXIMUM_QUALITY)) {
                increaseQuality(item);
            }

            if ((item.sellIn < SECOND_MINIMUM_SELL_IN_DAYS)
                    && (item.quality < Constants.MAXIMUM_QUALITY)) {
                increaseQuality(item);
            }

            increaseQuality(item);
            decreaseSellIn(item);

            setQualityToZeroIfItemHasPastSellInDate(item);
        }
    },

    CONJURED_ITEM("Conjured Item") {

        private final int CONJURED_ITEM_MINIMUM_QUALITY = 2;

        @Override
        public void update(Item item) {
            if (item.quality < CONJURED_ITEM_MINIMUM_QUALITY) {
                item.quality = Constants.MINIMUM_QUALITY;
            } else {
                decreaseQuality(item, by(2));
            }
            decreaseSellIn(item);
        }
    },

    SULFURAS("Sulfuras, Hand of Ragnaros") {
        @Override
        public void update(Item item) {
        }
    },

    ANY_ITEM("Any Item") {
        @Override
        public void update(Item item) {
            if (item.quality > Constants.MINIMUM_QUALITY) {
                decreaseQuality(item, by(1));
                decreaseSellIn(item);

                decreaseQualityIfQualityIs_0_OrMoreAndItemHasPastSellInDate(item);
            }
        }
    };

    private final String itemName;

    ItemUpdater(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }

    void increaseQualityIfItemHasPastSellInDate(Item item) {
        if (item.sellIn < Constants.MINIMUM_SELL_IN_DAYS) {
            increaseQuality(item);
        }
    }

    void decreaseQualityIfQualityIs_0_OrMoreAndItemHasPastSellInDate(Item item) {
        if ((item.quality > Constants.MINIMUM_QUALITY)
                && (item.sellIn < Constants.MINIMUM_SELL_IN_DAYS)) {
            decreaseQuality(item, by(1));
        }
    }

    void setQualityToZeroIfItemHasPastSellInDate(Item item) {
        if (item.sellIn < Constants.MINIMUM_SELL_IN_DAYS) {
            item.quality = Constants.MINIMUM_QUALITY;
        }
    }

    void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    void decreaseQuality(Item item, int by) {
        item.quality = item.quality - by;
    }

    int by(int value) {
        return value;
    }

    static void applyUpdateTo(Item item) {
        ItemUpdater itemType = ItemUpdater.getItemFor(item.name);
        itemType.update(item);
    }

    private static ItemUpdater getItemFor(String itemName) {
        for (ItemUpdater itemType: values()) {
            if (itemType.itemName.equals(itemName)) {
                return itemType;
            }
        }
        return ANY_ITEM;
    }

    private static class Constants {
        private static final int MAXIMUM_QUALITY = 50;
        private static final int MINIMUM_QUALITY = 0;
        private static final int MINIMUM_SELL_IN_DAYS = 0;
    }
}
