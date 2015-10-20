package com.gildedrose;

public class InnKeeper {
    protected static final String AGED_BRIE = "Aged Brie";
    protected static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    protected static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    protected static final String CONJURED = "Conjured";

    public static Item create(String itemName, SellIn sellIn, Quality quality) {
        switch (itemName) {
            case AGED_BRIE: return new AgedBrie(itemName, sellIn, quality);
            case BACKSTAGE_PASSES: return new BackstagePasses(itemName, sellIn, quality);
            case SULFURAS: return new Sulfuras(itemName, sellIn, quality);
            case CONJURED: return new Conjured(itemName, sellIn, quality);
            default: return new StandardItem(itemName, sellIn, quality);
        }
    }
}