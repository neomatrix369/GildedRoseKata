package com.gildedrose;

public class Item {

    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    private static final int ZERO_DAYS = 0;

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public boolean is(String itemName) {
        return itemName.equals(name);
    }

    void decreaseSellIn() {
        sellIn = sellIn - 1;
    }

    boolean isExpired() {
        return sellIn < ZERO_DAYS;
    }

    void increaseQuality() {
        if (quality < MAXIMUM_QUALITY) {
            quality = quality + 1;
        }
    }

    void decreaseQuality() {
        if (quality > MINIMUM_QUALITY) {
            quality = quality - 1;
        }
    }

    void setQualityToMinimum() {
        quality = MINIMUM_QUALITY;
    }

    public void update() {}
}
