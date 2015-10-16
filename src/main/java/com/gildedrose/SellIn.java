package com.gildedrose;

public class SellIn {
    private static final Days MINIMUM_DAYS = new Days(0);

    private Days days;

    public SellIn(Days days) {
        this.days = days;
    }

    public boolean isPast(Days days) {
        return this.days.isLessThan(days);
    }

    public void decrease() {
        days.decrease();
    }

    @Override
    public String toString() {
        return String.valueOf(days.asNumber());
    }

    boolean isPastMinimumDays() {
        return isPast(MINIMUM_DAYS);
    }
}
