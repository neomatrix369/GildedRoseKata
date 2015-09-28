package com.gildedrose;

public enum ItemType implements ItemTypeAction {
    AGED_BRIE("Aged Brie") {
        @Override
        public void update(Item item) {
            if (item.quality < 50) {
                increaseQuality(item);
                decreaseSellIn(item);

                increaseQualityIfItemHasPastSellinDate(item);
            }
        }
    },

    BACK_STAGE_PASSES("Backstage passes to a TAFKAL80ETC concert") {
        @Override
        public void update(Item item) {
            if ((item.sellIn < 11)
                    && (item.quality < 50)) {
                increaseQuality(item);
            }

            if ((item.sellIn < 6)
                    && (item.quality < 50)) {
                increaseQuality(item);
            }

            increaseQuality(item);
            decreaseSellIn(item);

            setQualityToZeroIfItemHasPastSellInDate(item);
        }
    },

    CONJURED_ITEM("Conjured Item") {
        @Override
        public void update(Item item) {
            if (item.quality < 1) {
                item.quality = 0;
            } else {
                decreaseQuality(item, by(2));
            }
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
            if (item.quality > 0){
                decreaseQuality(item, by(1));
                decreaseSellIn(item);

                decreaseQualityIfItemHasPastSellInDate(item);
            }
        }
    };

    private final String itemName;

    ItemType(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }

    void increaseQualityIfItemHasPastSellinDate(Item item) {
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    void decreaseQualityIfItemHasPastSellInDate(Item item) {
        if ((item.quality > 0)
                && (item.sellIn < 0)) {
            decreaseQuality(item, by(1));
        }
    }

    void setQualityToZeroIfItemHasPastSellInDate(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
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

    static void updateItem(Item item) {
        ItemType itemType = ItemType.getItemFor(item.name);
        itemType.update(item);
    }

    private static ItemType getItemFor(String itemName) {
        for (ItemType itemType: values()) {
            if (itemType.itemName.equals(itemName)) {
                return itemType;
            }
        }
        return ANY_ITEM;
    }
}
