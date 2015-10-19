package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.Product.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConjuredShould {
    @Test public void
    degrade_in_quality_twice_as_fast_normal_item_when_not_expired() {
        Item actualItemQuality = createConjuredUsing(new SellIn(new Days(10)), new Quality(12));

        actualItemQuality.update();

        Item expectedItemQuality = createConjuredUsing(new SellIn(new Days(9)), new Quality(10));
        assertThat(actualItemQuality, is(equalTo(expectedItemQuality)));
    }

    @Test public void
    degrade_in_quality_twice_as_fast_its_does_when_expired() {
        Item actualConjuredItem = createConjuredUsing(new SellIn(new Days(0)), new Quality(9));

        actualConjuredItem.update();

        Item expectedConjuredItem = createConjuredUsing(new SellIn(new Days(-1)), new Quality(5));
        assertThat(actualConjuredItem, is(equalTo(expectedConjuredItem)));
    }

    private Conjured createConjuredUsing(SellIn sellIn, Quality quality) {
        return new Conjured(CONJURED, sellIn, quality);
    }
}
