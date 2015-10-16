package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AgedBrieShould {
    @Test public void
    increase_quality_by_1_when_not_expired() {
        Item item = new AgedBrie(Product.AGED_BRIE, getSellInFor(1), getQualityOf(9));

        item.update();

        Item expectedItem = createItemUsing(Product.AGED_BRIE, getSellInFor(0), getQualityOf(10));
        assertThat(item, is(expectedItem));
    }

    @Test public void
    increase_quality_twice_as_fast_when_item_is_expired() {
        Item item = new AgedBrie(Product.AGED_BRIE, getSellInFor(0), getQualityOf(9));

        item.update();

        Item expectedItem = createItemUsing(Product.AGED_BRIE, getSellInFor(-1), getQualityOf(11));
        assertThat(item, is(expectedItem));
    }

    private Item createItemUsing(String itemName, SellIn sellIn, Quality quality) {
        return new AgedBrie(itemName, sellIn, quality);
    }

    private Quality getQualityOf(int value) {
        return new Quality(value);
    }

    private SellIn getSellInFor(int days) {
        return new SellIn(new Days(days));
    }
}