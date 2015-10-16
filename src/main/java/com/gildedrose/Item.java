package com.gildedrose;

public class Item {

    public String name;

    public SellIn sellIn;

    public Quality quality;

    public Item(String name, SellIn sellIn, Quality quality) {
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

    void setQualityToMinimum() {
        quality.setToMinimum();
    }

    boolean isExpired() {
        return sellIn.isPastMinimumDays();
    }

    boolean expiresIn(Days days) {
        return sellIn.isPast(days);
    }

    void decreaseSellIn() {
        sellIn.decrease();
    }
}
