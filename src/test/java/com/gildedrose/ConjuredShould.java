package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConjuredShould {
    @Test public void
    degrade_in_quality_twice_as_fast_normal_item_when_not_expired() {
        Item actualItemQuality = new Conjured(Product.CONJURED, new SellIn(new Days(10)), new Quality(12));

        actualItemQuality.update();

        Item expectedItemQuality = new Conjured(Product.CONJURED, new SellIn(new Days(9)), new Quality(10));
        assertThat(actualItemQuality, is(equalTo(expectedItemQuality)));
    } 
}
