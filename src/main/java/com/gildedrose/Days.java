package com.gildedrose;

public class Days {
    private int value;

    public Days(int value) {
        this.value = value;
    }

    public boolean isLessThan(Days days) {
        return value < days.asNumber();
    }

    public void decrease() {
        value--;
    }

    public int asNumber() {
        return value;
    }
}
