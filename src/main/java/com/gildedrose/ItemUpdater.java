package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class ItemUpdater {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured";
    public static final String ANY_OTHER_ITEM = "Any Other Item";

    private static Map<String, UpdatableItem> itemNameToUpdatableItem = new HashMap<String, UpdatableItem>() {
        {
            put(AGED_BRIE, new AgedBrie());
            put(BACKSTAGE_PASSES, new BackstagePasses());
            put(SULFURAS_HAND_OF_RAGNAROS, new Sulfuras());
            put(CONJURED, new Conjured());
        }
    };

    public static void update(Item item) {
        UpdatableItem updatableItem = itemNameToUpdatableItem.getOrDefault(item.name, new DefaultItem());
        updatableItem.update(item);
    }
}
