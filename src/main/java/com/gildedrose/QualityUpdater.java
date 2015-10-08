package com.gildedrose;

public interface QualityUpdater {
    int MINIMUM_QUALITY = 0;
    int MAXIMUM_QUALITY = 50;
    int MINIMUM_SELL_IN = 0;

    int BY_ONE = 1;

    void update(Item item);
}
