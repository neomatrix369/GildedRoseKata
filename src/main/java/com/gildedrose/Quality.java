package com.gildedrose;

public class Quality {

    private static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;

    private int value;

    public Quality(int value) {
        this.value = value;
    }

    public boolean canDecrease() {
        return value > MINIMUM_QUALITY;
    }

    public void decrease() {
        value--;
    }

    public boolean canIncrease() {
        return value < MAXIMUM_QUALITY;
    }

    public void increase() {
        value++;
    }

    public void setToMinimum() {
        value = MINIMUM_QUALITY;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
