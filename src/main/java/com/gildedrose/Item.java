package com.gildedrose;

public class Item {

    String name;

    private int sellIn;

    private int quality;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    private void decreaseSellIn() {
        sellIn = sellIn - 1;
    }

    private void increaseQuality() {
        quality = quality + 1;
    }

    private void decreaseQuality() {
        quality = quality - 1;
    }

    private void setQualityToZero() {
        quality = 0;
    }

    void updateBackstagePass() {
        if (quality < 50) {
            increaseQuality();

            if ((sellIn < 11) && (quality < 50)) {
                increaseQuality();
            }

            if ((sellIn < 6) && (quality < 50)) {
                increaseQuality();
            }
        }

        decreaseSellIn();

        if (sellIn < 0) {
            setQualityToZero();
        }
    }

    void updateAgedBrie() {
        decreaseSellIn();

        if (quality < 50) {
            increaseQuality();
        }

        if (sellIn < 0 && quality < 50) {
            increaseQuality();
        }
    }

    void updateOthers() {
        decreaseSellIn();

        if (quality > 0) {
            decreaseQuality();
        }

        if (sellIn < 0 && quality > 0) {
            decreaseQuality();
        }
    }
}
