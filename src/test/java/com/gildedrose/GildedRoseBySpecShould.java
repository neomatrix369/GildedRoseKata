package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.GildedRose.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GildedRoseBySpecShould {

    @Test public void
    increase_the_quality_of_Aged_Brie_by_1_as_item_has_not_passed_SellIn_date() {
        GildedRose app = prepareGildedRoseWithItems(new Item[] {
                new Item(AGED_BRIE, sellIn(1), qualityOf(1))
        });

        app.updateQuality();

        assertThat(app.items[0].quality, is(2));
    }

    @Test public void
    increase_the_quality_of_Aged_Brie_by_2_as_item_has_passed_SellIn_date() {
        GildedRose app = prepareGildedRoseWithItems(new Item[] {
                new Item(AGED_BRIE, sellIn(0), qualityOf(2))
        });

        app.updateQuality();

        assertThat(app.items[0].quality, is(4));
    }

    @Test public void
    never_change_the_quality_of_item_Sufluras_as_time_passes() {
        GildedRose app = prepareGildedRoseWithItems(new Item[] {
                new Item(SULFURAS_HAND_OF_RAGNAROS, sellIn(0), qualityOf(2))
        });

        app.updateQuality();

        assertThat(app.items[0].quality, is(2));
    }

    @Test public void
    never_change_the_quality_of_any_item_past_50() {
        GildedRose app = prepareGildedRoseWithItems(new Item[] {
                new Item(AGED_BRIE, sellIn(0), qualityOf(50))
        });

        app.updateQuality();

        assertThat(app.items[0].quality, is(50));
    }

    @Test public void
    increase_the_quality_of_backstage_passes_by_2_when_sellIn_for_it_is_10_days() {
        GildedRose app = prepareGildedRoseWithItems(new Item[] {
                new Item(BACKSTAGE_PASSES, sellIn(10), qualityOf(25))
        });

        app.updateQuality();

        assertThat(app.items[0].quality, is(27));
    }


    @Test public void
    increase_the_quality_of_backstage_passes_by_2_when_sellIn_for_it_is_8_days() {
        GildedRose app = prepareGildedRoseWithItems(new Item[] {
                new Item(BACKSTAGE_PASSES, sellIn(8), qualityOf(20))
        });

        app.updateQuality();

        assertThat(app.items[0].quality, is(22));
    }

    @Test public void
    increase_the_quality_of_backstage_passes_by_3_when_sellIn_for_it_is_5_days() {
        GildedRose app = prepareGildedRoseWithItems(new Item[] {
                new Item(BACKSTAGE_PASSES, sellIn(5), qualityOf(22))
        });

        app.updateQuality();

        assertThat(app.items[0].quality, is(25));
    }


    @Test public void
    increase_the_quality_of_backstage_passes_by_3_when_sellIn_for_it_is_3_days() {
        GildedRose app = prepareGildedRoseWithItems(new Item[] {
                new Item(BACKSTAGE_PASSES, sellIn(3), qualityOf(27))
        });

        app.updateQuality();

        assertThat(app.items[0].quality, is(30));
    }


    @Test public void
    decrease_the_quality_of_backstage_passes_to_0_when_sellIn_for_it_is_0_days() {
        GildedRose app = prepareGildedRoseWithItems(new Item[] {
                new Item(BACKSTAGE_PASSES, sellIn(0), qualityOf(27))
        });

        app.updateQuality();

        assertThat(app.items[0].quality, is(0));
    }

    @Test public void
    decrease_the_quality_of_any_other_item_by_1_when_quality_is_greater_than_0() {
        GildedRose app = prepareGildedRoseWithItems(new Item[] {
                new Item(ANY_OTHER_ITEM, sellIn(1), qualityOf(25))
        });

        app.updateQuality();

        assertThat(app.items[0].quality, is(24));
    }

    @Test public void
    decrease_the_quality_of_any_other_item_by_2_when_quality_is_greater_than_0_and_sellIn_less_than_1() {
        GildedRose app = prepareGildedRoseWithItems(new Item[] {
                new Item(ANY_OTHER_ITEM, sellIn(-1), qualityOf(23))
        });

        app.updateQuality();

        assertThat(app.items[0].quality, is(21));
    }


    @Test public void
    decrease_the_quality_of_conjured_item_by_2_when_quality_is_greater_than_0_and_sellIn_less_than_1() {
        GildedRose app = prepareGildedRoseWithItems(new Item[] {
                new Item(CONJURED, sellIn(-1), qualityOf(19))
        });

        app.updateQuality();

        assertThat(app.items[0].quality, is(17));
    }

    private GildedRose prepareGildedRoseWithItems(Item[] items) {
        return new GildedRose(items);
    }

    private int sellIn(int value) {
        return value;
    }

    private int qualityOf(int value) {
        return value;
    }

}