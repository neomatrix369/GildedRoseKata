package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.InnKeeper.BACKSTAGE_PASSES;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BackstagePassesShould {
    @Test public void
    increase_the_quality_by_1_if_not_expired_and_sell_in_is_11_days() {
        Item item = new BackstagePasses(BACKSTAGE_PASSES, 11, 5);

        item.update();

        assertThat(item.quality, is(qualityOf(6)));
    }

    @Test public void
    increase_the_quality_by_2_if_not_expired_and_sell_in_is_10_days() {
        Item item = new BackstagePasses(BACKSTAGE_PASSES, 10, 5);

        item.update();

        assertThat(item.quality, is(qualityOf(7)));
    }

    @Test public void
    increase_the_quality_by_2_if_not_expired_and_sell_in_is_6_days() {
        Item item = new BackstagePasses(BACKSTAGE_PASSES, 6, 3);

        item.update();

        assertThat(item.quality, is(qualityOf(5)));
    }

    @Test public void
    increase_the_quality_by_3_if_not_expired_and_sell_in_is_5_days() {
        Item item = new BackstagePasses(BACKSTAGE_PASSES, 5, 2);

        item.update();

        assertThat(item.quality, is(qualityOf(5)));
    }


    @Test public void
    increase_the_quality_by_3_if_not_expired_and_sell_in_is_4_days() {
        Item item = new BackstagePasses(BACKSTAGE_PASSES, 4, 3);

        item.update();

        assertThat(item.quality, is(qualityOf(6)));
    }

    @Test public void
    set_the_quality_to_0_if_expired() {
        Item item = new BackstagePasses(BACKSTAGE_PASSES, 0, 2);

        item.update();

        assertThat(item.quality, is(qualityOf(0)));
    }

    private int qualityOf(int value) {
        return value;
    }
}