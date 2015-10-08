package com.gildedrose;

public interface QualityUpdater {
    int MINIMUM_QUALITY = 0;
    int MAXIMUM_QUALITY = 50;
    int BY_THREE = 3;
    int BY_TWO = 2;
    int BY_ONE = 1;

    int MINIMUM_SELL_IN = 0;
    int FIRST_QUALITY_INCREASE_POINT = 10;
    int SECOND_QUALITY_INCREASE_POINT = 5;

    void update(Item item);
}
