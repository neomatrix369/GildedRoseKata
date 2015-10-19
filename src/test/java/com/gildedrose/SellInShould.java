package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SellInShould {

    protected static final int TEN_DAYS = 10;
    protected static final int TWELVE_DAYS = 12;
    protected static final int THIRTEEN_DAYS = 13;
    protected static final int MINIMUM_DAYS = 0;

    @Test public void
    decrease_day_count_with_every_passing_day() {
        SellIn actualSellIn = getSellInFor(11);

        actualSellIn.decrease();

        assertThat(actualSellIn, is(equalTo(getSellInFor(TEN_DAYS))));
    }

    @Test public void
    indicate_that_sell_in_is_past_another_sell_in_value() {
        assertTrue(getSellInFor(TWELVE_DAYS).isPast(new Days(THIRTEEN_DAYS)));
    }

    @Test public void
    indicate_that_it_is_past_expiry_days() {
        SellIn actualSellIn = getSellInFor(MINIMUM_DAYS);

        actualSellIn.decrease();

        assertTrue(actualSellIn.isPastExpiryDay());
    }

    private SellIn getSellInFor(int days) {
        return new SellIn(new Days(days));
    }

}