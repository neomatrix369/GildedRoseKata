package com.gildedrose;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static com.gildedrose.Quality.NORMAL_QUALITY_CHANGE_RATE;

public class Item {

    public String name;

    private SellIn sellIn;

    private Quality quality;

    public Item(String name, SellIn sellIn, Quality quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    protected boolean is(String itemName) {
        return name.equals(itemName);
    }

    protected void decreaseQuality() {
        decreaseQualityBy(NORMAL_QUALITY_CHANGE_RATE);
    }

    protected void decreaseQualityBy(int rate) {
        quality.decreaseBy(rate);
    }

    protected void increaseQuality() {
        increaseQualityBy(NORMAL_QUALITY_CHANGE_RATE);
    }

    protected void increaseQualityBy(int rate) {
        quality.increaseBy(rate);
    }

    protected void setQualityToMinimum() {
        quality.setToMinimum();
    }

    protected boolean isExpired() {
        return sellIn.isPastExpiryDay();
    }

    protected boolean expiresIn(Days days) {
        return sellIn.isPast(days);
    }

    protected void decreaseSellIn() {
        sellIn.decrease();
    }

    public void update() {}

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return new EqualsBuilder()
                .append(name, item.name)
                .append(sellIn, item.sellIn)
                .append(quality, item.quality)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(sellIn)
                .append(quality)
                .toHashCode();
    }
}