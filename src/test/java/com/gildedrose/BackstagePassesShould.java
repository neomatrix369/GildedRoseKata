package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.Product.BACKSTAGE_PASSES;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BackstagePassesShould {

    @Test
    public void
    increase_quality_by_1_if_item_is_not_expired() {
        Item actualItem = new BackstagePasses(BACKSTAGE_PASSES, new SellIn(new Days(20)), new Quality(10));

        actualItem.update();

        Item expectedItem = new BackstagePasses(BACKSTAGE_PASSES, new SellIn(new Days(19)), new Quality(11));
        assertThat(actualItem, is(expectedItem));
    }

    @Test
    public void
    increase_quality_by_2_if_item_is_10_days_from_expiring() {
        Item actualItem = new BackstagePasses(BACKSTAGE_PASSES, new SellIn(new Days(10)), new Quality(7));

        actualItem.update();

        Item expectedItem = new BackstagePasses(BACKSTAGE_PASSES, new SellIn(new Days(9)), new Quality(9));
        assertThat(actualItem, is(expectedItem));
    }

    @Test
    public void
    increase_quality_by_3_if_item_is_5_days_from_expiring() {
        Item actualItem = new BackstagePasses(BACKSTAGE_PASSES, new SellIn(new Days(5)), new Quality(5));

        actualItem.update();

        Item expectedItem = new BackstagePasses(BACKSTAGE_PASSES, new SellIn(new Days(4)), new Quality(8));
        assertThat(actualItem, is(expectedItem));
    }

    @Test
    public void
    set_the_quality_to_minimum_when_item_is_expired() {
        Item actualItem = new BackstagePasses(BACKSTAGE_PASSES, new SellIn(new Days(0)), new Quality(10));

        actualItem.update();

        Item expectedItem = new BackstagePasses(BACKSTAGE_PASSES, new SellIn(new Days(-1)), Quality.MINIMUM_QUALITY);
        assertThat(actualItem, is(expectedItem));
    }
}