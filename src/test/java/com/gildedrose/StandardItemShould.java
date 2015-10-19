package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StandardItemShould {

    @Test
    public void
    decrease_quality_by_1_if_not_expired() {
        Item item = new StandardItem("Standard item", 10, 5);

        item.update();

        assertThat(item.quality, is(qualityOf(4)));
    }

    @Test public void
    decrease_quality_by_2_if_expired() {
        Item item = new StandardItem("Standard item", 0, 4);

        item.update();

        assertThat(item.quality, is(qualityOf(2)));
    }

    private int qualityOf(int value) {
        return value;
    }

}