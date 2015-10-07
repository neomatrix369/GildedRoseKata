package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.gildedrose.ItemUpdater.*;
import static com.gildedrose.ItemUpdater.CONJURED;
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
                                "never change the quality of item Sufluras as time passes",
                                SULFURAS_HAND_OF_RAGNAROS, sellIn(-1), qualityOf(80), qualityOf(80),
                        },

                        {
                                "never change the quality of item Sufluras as time passes",
                                SULFURAS_HAND_OF_RAGNAROS, sellIn(0), qualityOf(80), qualityOf(80),
                        },

                        {
                                "never change the quality of item Sufluras as time passes",
                                SULFURAS_HAND_OF_RAGNAROS, sellIn(1), qualityOf(80), qualityOf(80),
                        },

                        {
                                "never change the quality of any item past 50",
                                AGED_BRIE, sellIn(0), qualityOf(50), qualityOf(50),
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
                                "decrease the quality of Backstage Passes to 0 when sellIn for it is 0 days",
                                BACKSTAGE_PASSES, sellIn(0), qualityOf(27), qualityOf(0)
                        },
                        {
                                "decrease the quality of any other item by 1 when quality is greater than 0",
                                ANY_OTHER_ITEM, sellIn(1), qualityOf(25), qualityOf(24)
                        },
                        {
                                "decrease the quality of any other item by 2 when quality is greater than 0 and sellIn less than 1",
                                ANY_OTHER_ITEM, sellIn(-1), qualityOf(23), qualityOf(21)
                        },
                        {
                                "not decrease the quality of any other item when quality is 0",
                                ANY_OTHER_ITEM, sellIn(1), qualityOf(0), qualityOf(0)
                        },

                        {
                                "decrease the quality of Conjured item by 2 when quality is greater than 0 and sellIn less than 1",
                                CONJURED, sellIn(1), qualityOf(19), qualityOf(17)
                        },

                        {
                                "the quality of Conjured item stays at 0 when quality is 2 and sellIn is greater than 0",
                                CONJURED, sellIn(1), qualityOf(2), qualityOf(0)
                        },

                        {
                                "decrease the quality of Conjured item by 2 when quality is greater than 0 even if sellIn is 0",
                                CONJURED, sellIn(0), qualityOf(10), qualityOf(8)
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
        GildedRose app = prepareGildedRoseWithItems(new Item[]{
                new Item(itemName, actualSellIn, actualQuality)
        });

        app.updateQuality();

        assertThat(app.items[0].quality, is((expectedQuality)));
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