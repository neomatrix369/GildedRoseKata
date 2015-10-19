package com.gildedrose;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Quality {

    public static final Quality MINIMUM_QUALITY = new Quality(0);
    public static final Quality MAXIMUM_QUALITY = new Quality(50);

    public static final int NORMAL_QUALITY_CHANGE_RATE = 1;

    private int value;

    public Quality(int value) {
        this.value = value;
    }

    private boolean canDecrease() {
        return value > MINIMUM_QUALITY.value;
    }

    public void decrease() {
        decreaseBy(NORMAL_QUALITY_CHANGE_RATE);
    }

    public void decreaseBy(int rate) {
        if (canDecrease()) {
            value -= rate;
        }
    }

    private boolean canIncrease() {
        return value < MAXIMUM_QUALITY.value;
    }

    public void increase() {
        if (canIncrease()) {
            value++;
        }
    }

    public void setToMinimum() {
        value = MINIMUM_QUALITY.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Quality quality = (Quality) o;

        return new EqualsBuilder()
                .append(value, quality.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(value)
                .toHashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}