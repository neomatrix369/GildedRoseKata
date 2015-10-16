package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public Quality quality;

    public Item(String name, int sellIn, Quality quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public boolean canDecreaseQuality() {
        return quality.canDecrease();
    }

    public boolean canIncreaseQuality() {
        return quality.canIncrease();
    }

    public void decreaseQuality() {
        quality.decrease();
    }

    public void increaseQuality() {
        quality.increase();
    }
}
