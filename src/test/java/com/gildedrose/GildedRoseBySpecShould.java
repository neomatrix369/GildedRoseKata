package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.gildedrose.ItemUpdater.AGED_BRIE;
import static com.gildedrose.ItemUpdater.BACKSTAGE_PASSES;
import static com.gildedrose.ItemUpdater.CONJURED;
import static com.gildedrose.ItemUpdater.SULFURAS_HAND_OF_RAGNAROS;
import static com.gildedrose.ItemUpdater.DEFAULT_ITEM;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class GildedRoseBySpecShould {

    private final String itemName;
    private final int actualSellIn;
    private final int actualQuality;
    private final int expectedQuality;

    @Parameterized.Parameters(name = "{0} with sell in {1} and quality of {2}, changes to quality of {3}.")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {
                                "increase the quality of Aged Brie by 1 as item has not passed SellIn date",
                                AGED_BRIE, sellIn(1), qualityOf(1), qualityOf(2)
                        },
                        {
                                "increase the quality of Aged Brie by 2 as item has passed SellIn date",
                                AGED_BRIE, sellIn(0), qualityOf(2), qualityOf(4)
                        },
                        {
                                "never change the quality of item Sulfuras as time passes",
                                SULFURAS_HAND_OF_RAGNAROS, sellIn(-1), qualityOf(80), qualityOf(80),
                        },

                        {
                                "never change the quality of item Sulfuras as time passes",
                                SULFURAS_HAND_OF_RAGNAROS, sellIn(0), qualityOf(80), qualityOf(80),
                        },

                        {
                                "never change the quality of item Sulfuras as time passes",
                                SULFURAS_HAND_OF_RAGNAROS, sellIn(1), qualityOf(80), qualityOf(80),
                        },

                        {
                                "never change the quality of any item past 50",
                                AGED_BRIE, sellIn(0), qualityOf(50), qualityOf(50),
                        },

                        {
                                "increase the quality of Backstage Passes by 1 when sellIn for it is 11 days",
                                BACKSTAGE_PASSES, sellIn(11), qualityOf(25), qualityOf(26)
                        },

                        {
                                "increase the quality of Backstage Passes by 2 when sellIn for it is 10 days",
                                BACKSTAGE_PASSES, sellIn(10), qualityOf(25), qualityOf(27)
                        },
                        {
                                "increase the quality of Backstage Passes by 2 when sellIn for it is 8 days",
                                BACKSTAGE_PASSES, sellIn(8), qualityOf(20), qualityOf(22)
                        },
                        {
                                "increase the quality of Backstage Passes by 3 when sellIn for it is 5 days",
                                BACKSTAGE_PASSES, sellIn(5), qualityOf(22), qualityOf(25)
                        },
                        {
                                "increase the quality of Backstage Passes by 3 when sellIn for it is 3 days",
                                BACKSTAGE_PASSES, sellIn(3), qualityOf(27), qualityOf(30)
                        },

                        {
                                "Set the quality of Backstage Passes to 0 when sellIn for it is -1 days",
                                BACKSTAGE_PASSES, sellIn(-1), qualityOf(27), qualityOf(0)
                        },
                        {
                                "decrease the quality of Backstage Passes to 0 when sellIn for it is 0 days",
                                BACKSTAGE_PASSES, sellIn(0), qualityOf(27), qualityOf(0)
                        },
                        {
                                "decrease the quality of default item by 1 when quality is 25 (> 0) and sell in is 1 (> 0)",
                                DEFAULT_ITEM, sellIn(1), qualityOf(25), qualityOf(24)
                        },
                        {
                                "decrease the quality of default item by 2 when quality is 23 (> 0) and sell in is 0 (= 0)",
                                DEFAULT_ITEM, sellIn(0), qualityOf(23), qualityOf(21)
                        },
                        {
                                "not decrease the quality of default item when quality is 0",
                                DEFAULT_ITEM, sellIn(1), qualityOf(0), qualityOf(0)
                        },

                        {
                                "decrease the quality of Conjured item by 2 when quality is 19 (> 0) and sellIn is 1 (> 0)",
                                CONJURED, sellIn(1), qualityOf(19), qualityOf(17)
                        },

                        {
                                "the quality of Conjured item stays at 0 when quality is 2 and sellIn is 0",
                                CONJURED, sellIn(0), qualityOf(2), qualityOf(0)
                        },

                        {
                                "decrease the quality of Conjured item by 2 when quality is 8 (> 0) and sellIn is 1",
                                CONJURED, sellIn(1), qualityOf(10), qualityOf(8)
                        },

                        {
                                "decrease the quality of Conjured item by 4 when quality 10 (> 0) and sellIn is 0",
                                CONJURED, sellIn(0), qualityOf(10), qualityOf(6)
                        },


                }
        );
    }

    public GildedRoseBySpecShould(String testCaseDescription,
                                  String itemName,
                                  int actualSellIn,
                                  int actualQuality,
                                  int expectedQuality) {
        this.itemName = itemName;
        this.actualSellIn = actualSellIn;
        this.actualQuality = actualQuality;
        this.expectedQuality = expectedQuality;
    }

    @Test
    public void
    change_the_quality_of_an_item_under_the_given_conditions() {
        final GildedRose app = prepareGildedRoseWithItems(new Item[]{
                new Item(itemName, actualSellIn, actualQuality)
        });

        app.updateQuality();

        assertThat(app.items[0].quality, is(expectedQuality));
    }

    private GildedRose prepareGildedRoseWithItems(Item[] items) {
        return new GildedRose(items);
    }

    private static int sellIn(int value) {
        return value;
    }

    private static int qualityOf(int value) {
        return value;
    }
}