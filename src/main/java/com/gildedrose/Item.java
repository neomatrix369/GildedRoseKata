package com.gildedrose;

public class Item {

    public String name;

    private SellIn sellIn;

    private Quality quality;

    public Item(String name, SellIn sellIn, Quality quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    boolean is(String itemName) {
        return name.equals(itemName);
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
        return sellIn.isPastExpiryDay();
    }

    boolean expiresIn(Days days) {
        return sellIn.isPast(days);
    }

    void decreaseSellIn() {
        sellIn.decrease();
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void updateAgedBrie() {
        increaseQuality();

        decreaseSellIn();

        if (isExpired()) {
            increaseQuality();
        }
    }

    void updateBackstagePasses() {
        increaseQuality();

        if (is(GildedRose.BACKSTAGE_PASSES)) {
            if (expiresIn(GildedRose.ELEVEN_DAYS)) {
                increaseQuality();
            }

            if (expiresIn(GildedRose.SIX_DAYS)) {
                increaseQuality();
            }
        }

        decreaseSellIn();

        if (isExpired()) {
            setQualityToMinimum();
        }
    }

    void updateSulfuras() {
    }

    void updateStandardItem() {
        decreaseQuality();

        decreaseSellIn();

        if (isExpired()) {
            decreaseQuality();
        }
    }
}
