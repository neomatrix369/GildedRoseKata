package com.gildedrose;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Days {
    private int value;

    public Days(int value) {
        this.value = value;
    }

    public boolean isPast(Days days) {
        return value < days.asNumber();
    }

    public void decrease() {
        value--;
    }

    public int asNumber() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Days days = (Days) o;

        return new EqualsBuilder()
                .append(value, days.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(value)
                .toHashCode();
    }
}
