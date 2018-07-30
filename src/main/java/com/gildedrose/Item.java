package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void decreaseSellIn() {
        sellIn = sellIn - 1;
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

   void increaseQuality() {
        quality = quality + 1;
    }

   public void decreaseQuality() {
        quality = quality - 1;
    }

   public void setQualityToZero() {
        quality = 0;
    }
}
