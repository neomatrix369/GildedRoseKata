package com.gildedrose;

public class Product {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static Item create(String name, int sellIn, int quality) {
        switch (name) {
            case AGED_BRIE:
                return new AgedBrie(name, sellIn, quality);
            case BACKSTAGE_PASSES:
                return new BackstagePasses(name, sellIn, quality);
            case SULFURAS:
                return new Sulfuras(name, sellIn, quality);
            default:
                return new StandardItem(name, sellIn, quality);
        }
    }
}