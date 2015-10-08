package com.gildedrose;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ItemUpdater {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured";
    public static final String ANY_OTHER_ITEM = "Any Other Item";

    private static Map<String, Class<? extends UpdatableItem>> itemNameToUpdatableItem
            = new HashMap<String, Class<? extends UpdatableItem>>() {
        {
            put(AGED_BRIE, AgedBrie.class);
            put(BACKSTAGE_PASSES, BackstagePasses.class);
            put(SULFURAS_HAND_OF_RAGNAROS, Sulfuras.class);
            put(CONJURED, Conjured.class);
        }
    };

    public static void update(Item item) {
        UpdatableItem updatableItem = createInstanceFromClass(
                itemNameToUpdatableItem.getOrDefault(item.name, DefaultItem.class), item
        );

        updatableItem.update();
    }

    private static UpdatableItem createInstanceFromClass(Class<? extends UpdatableItem> classOfUpdatableItem, Item item) {
        try {
            Constructor<? extends UpdatableItem> updateItemConstructor = classOfUpdatableItem.getConstructor(Item.class);
            return updateItemConstructor.newInstance(item);
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException ex) {
            throw new IllegalArgumentException(String.format("Error with item of class %s, error message: %s.",
                    classOfUpdatableItem.getSimpleName(), ex.getMessage()));
        }
    }
}