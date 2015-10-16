package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StandardItemShould {

    @Test public void
    decrease_quality_by_1_when_item_is_not_expired() {
        Item actualItem = new StandardItem("Any standard item", new SellIn(new Days(5)), new Quality(10));

        actualItem.update();

        Item expectedItem = new StandardItem("Any standard item", new SellIn(new Days(4)), new Quality(9));
        assertThat(actualItem, is(expectedItem));
    }

    @Test public void
    decrease_quality_twice_as_fast_when_item_is_expired() {
        Item actualItem = new StandardItem("Any standard item", new SellIn(new Days(0)), new Quality(10));

        actualItem.update();

        Item expectedItem = new StandardItem("Any standard item", new SellIn(new Days(-1)), new Quality(8));
        assertThat(actualItem, is(expectedItem));
    }
}