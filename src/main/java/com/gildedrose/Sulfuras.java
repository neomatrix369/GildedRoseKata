package com.gildedrose;

class Sulfuras extends Product {

    public Sulfuras(Item item) {
        super(item);
    }


    @Override
    protected void changeQuality() {}

    @Override
    protected void decreaseSellIn() {}

    @Override
    protected void changeQualityIfExpired() {}
}