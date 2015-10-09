package com.gildedrose;

class ProductUpdater {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured";
    public static final String DEFAULT_ITEM = "Default Item";

    private static Product createProductFrom(Item item) {
        switch (item.name) {
            case AGED_BRIE: return new AgedBrie(item);
            case BACKSTAGE_PASSES: return new BackstagePasses(item);
            case CONJURED: return new Conjured(item);
            case SULFURAS_HAND_OF_RAGNAROS: return new Sulfuras(item);
            default: return new DefaultItem(item);
        }
    }

    public static void update(Item item) {
        final Product product = createProductFrom(item);
        product.update();
    }
}