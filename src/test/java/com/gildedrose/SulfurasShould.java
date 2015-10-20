package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.InnKeeper.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SulfurasShould {
    @Test public void
    sellIn_or_quality_stays_unchanged_when_update_is_applied_to_item() {
        Item actualItem = new Sulfuras(SULFURAS, new SellIn(new Days(1)), new Quality(80));

        actualItem.update();

        Item expectedItem = new Sulfuras(SULFURAS, new SellIn(new Days(1)), new Quality(80));
        assertThat(actualItem, is(equalTo(expectedItem)));
    }
}