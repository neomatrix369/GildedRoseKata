package com.gildedrose;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class SellIn {
    private static final Days MINIMUM_DAYS = new Days(0);

    private Days days;

    public SellIn(Days days) {
        this.days = days;
    }

    public boolean isPast(Days days) {
        return this.days.isPast(days);
    }

    public void decrease() {
        days.decrease();
    }

    boolean isPastExpiryDay() {
        return isPast(MINIMUM_DAYS);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SellIn sellIn = (SellIn) o;

        return new EqualsBuilder()
                .append(days, sellIn.days)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(days)
                .toHashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(days.asNumber());
    }
}
