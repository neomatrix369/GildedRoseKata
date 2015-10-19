package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.Product.SULFURAS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SulfurasShould {
    @Test public void
    quality_should_not_change_and_stays_the_same_as_when_created() {
        Item item = new Sulfuras(SULFURAS, 10, 80);

        item.update();

        assertThat(item.quality, is(equalTo(qualityOf(80))));
    }

    private int qualityOf(int value) {
        return value;
    }

}