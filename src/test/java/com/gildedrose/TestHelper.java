package com.gildedrose;

public class TestHelper {

    public static int expectedSellInOf(int value) {
        return value;
    }

    public static Item createItemFrom(String itemName, int initialSellIn, int initialQuality) {
        return new Item(itemName, initialSellIn, initialQuality);
    }

    public static int qualityOf(int value) {
        return value;
    }

    public static int sellInOf(int value) {
        return value;
    }
}
