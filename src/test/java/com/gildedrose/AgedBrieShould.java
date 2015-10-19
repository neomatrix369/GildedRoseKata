package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.Product.AGED_BRIE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AgedBrieShould {
    @Test public void
    increase_quality_by_1_if_not_expired() {
        Item item = new AgedBrie(AGED_BRIE, 10, 5);

        item.update();

        assertThat(item.quality, is(qualityOf(6)));
    }

    @Test public void
    increase_quality_by_2_if_expired() {
        Item item = new AgedBrie(AGED_BRIE, 0, 4);

        item.update();

        assertThat(item.quality, is(qualityOf(6)));
    }

    private int qualityOf(int value) {
        return value;
    }
}