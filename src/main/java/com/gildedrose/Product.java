package com.gildedrose;

import static com.gildedrose.GildedRose.*;

public class Product {
    public static Item create(String itemName, SellIn sellIn, Quality quality) {
        switch (itemName) {
            case AGED_BRIE: return new AgedBrie(itemName, sellIn, quality);
            case BACKSTAGE_PASSES: return new BackstagePasses(itemName, sellIn, quality);
            case SULFURAS: return new Sulfuras(itemName, sellIn, quality);
            default: return new StandardItem(itemName, sellIn, quality);
        }

    }
}
