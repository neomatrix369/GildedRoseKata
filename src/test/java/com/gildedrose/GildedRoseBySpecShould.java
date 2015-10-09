package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.gildedrose.ProductUpdater.AGED_BRIE;
import static com.gildedrose.ProductUpdater.DEFAULT_ITEM;
import static com.gildedrose.ProductUpdater.BACK_STAGE_PASSES;
import static com.gildedrose.ProductUpdater.CONJURED_ITEM;
import static com.gildedrose.ProductUpdater.SULFURAS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class GildedRoseBySpecShould {

    private final String useCaseDescription;
    private final String itemName;
    private final int actualSellIn;
    private final int actualQuality;
    private final int expectedQuality;

    @Parameterized.Parameters(name = "{0}: Quality of item {1} with a sell in days of {2}, and quality of {3}, gets quality of {4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {"Decrease quality by 2 if item has passed its sell in date",
                                DEFAULT_ITEM.toString(), sellIn(-1), qualityOf(2), qualityOf(0)},
                        {"The Quality of an item is never negative (past sell in date)",
                                DEFAULT_ITEM.toString(), sellIn(-1), qualityOf(1), qualityOf(0)},
                        {"The Quality of an item is never negative (past sell in date)",
                                DEFAULT_ITEM.toString(), sellIn(0), qualityOf(1), qualityOf(0)},
                        {"The Quality of an item is never negative (past sell in date)",
                                DEFAULT_ITEM.toString(), sellIn(-1), qualityOf(0), qualityOf(0)},

                        {"The Quality of Aged Brie can never more than 50 (near sell in date of 1)",
                                AGED_BRIE.toString(), sellIn(1), qualityOf(45), qualityOf(46)},
                        {"The Quality of Aged Brie can never more than 50 (near sell in date of 1)",
                                AGED_BRIE.toString(), sellIn(1), qualityOf(50), qualityOf(50)},
                        {"The Quality of Aged Brie increases by 1 when before sell in date",
                                AGED_BRIE.toString(), sellIn(1), qualityOf(48), qualityOf(49)},
                        {"The Quality of Aged Brie increases by 2 when past sell in date",
                                AGED_BRIE.toString(), sellIn(0), qualityOf(48), qualityOf(50)},
                        {"The Quality of Aged Brie can never more than 50 (near sell in date of 0)",
                                AGED_BRIE.toString(), sellIn(0), qualityOf(50), qualityOf(50)},
                        {"The Quality of Aged Brie increases by 2 but can never more than 50 (past sell in date)",
                                AGED_BRIE.toString(), sellIn(-1), qualityOf(50), qualityOf(50)},
                        {"The Quality of Aged Brie increases by 2 even if its past sell in date",
                                AGED_BRIE.toString(), sellIn(-1), qualityOf(48), qualityOf(50)},

                        {"The Quality of Sulfurus never changes (stays at 80) (past sell in days)",
                                SULFURAS.toString(), sellIn(0), qualityOf(80), qualityOf(80)},
                        {"The Quality of Sulfurus never changes (stays at 80) (past sell in days)",
                                SULFURAS.toString(), sellIn(-1), qualityOf(80), qualityOf(80)},
                        {"The Quality of Sulfurus never changes (stays at 80) (within sell in days)",
                                SULFURAS.toString(), sellIn(1), qualityOf(80), qualityOf(80)},

                        {"The Quality of BackStage Passes increases by 1 for 11 or more days of sell in days",
                                BACK_STAGE_PASSES.toString(), sellIn(11), qualityOf(10), qualityOf(11)},
                        {"The Quality of BackStage Passes increases by 2 when within 10 or less days of sell in days (10 days)",
                                BACK_STAGE_PASSES.toString(), sellIn(10), qualityOf(10), qualityOf(12)},
                        {"The Quality of BackStage Passes increases by 2 when within 10 or less days of sell in days (6 days)",
                                BACK_STAGE_PASSES.toString(), sellIn(6), qualityOf(12), qualityOf(14)},
                        {"The Quality of BackStage Passes increases by 3 when within 5 or less days of sell in days (5 days)",
                                BACK_STAGE_PASSES.toString(), sellIn(5), qualityOf(12), qualityOf(15)},
                        {"The Quality of BackStage Passes increases by 3 when within 1 or less days of sell in days (1 day)",
                                BACK_STAGE_PASSES.toString(), sellIn(1), qualityOf(12), qualityOf(15)},
                        {"The Quality of BackStage Passes drops to 0 after the concert (finished by a day)",
                                BACK_STAGE_PASSES.toString(), sellIn(0), qualityOf(10), qualityOf(0)},
                        {"The Quality of BackStage Passes drops to 0 after the concert (finished by 2 days)",
                                BACK_STAGE_PASSES.toString(), sellIn(-1), qualityOf(10), qualityOf(0)},

                        {"Conjured items degrade in Quality twice as fast as normal items",
                                CONJURED_ITEM.toString(), sellIn(1), qualityOf(10), qualityOf(8)},
                        {"Quality of Conjured items do not reduce to any value below 0",
                                CONJURED_ITEM.toString(), sellIn(1), qualityOf(0), qualityOf(0)},
                        {"Quality of Conjured items do not reduce to any value below 0, even if starting quality if less than 0",
                                CONJURED_ITEM.toString(), sellIn(1), qualityOf(-1), qualityOf(0)},
                }
        );
    }

    public GildedRoseBySpecShould(
            String useCaseDescription,
            String itemName,
            int actualSellIn,
            int actualQuality,
            int expectedQuality) {
        this.useCaseDescription = useCaseDescription;
        this.itemName = itemName;
        this.actualSellIn = actualSellIn;
        this.actualQuality = actualQuality;
        this.expectedQuality = expectedQuality;
    }

    @Test
    public void
    change_quality_item_with_respective_sellin_date_and_starting_quality() {
        GildedRose app = prepareGildedRose();

        app.updateQuality();

        assertThat(useCaseDescription, app.items[0].quality, is(equalTo(expectedQuality)));
    }

    private GildedRose prepareGildedRose() {
        Item[] items = new Item[]{new Item(itemName, actualSellIn, actualQuality)};
        return new GildedRose(items);
    }

    private static int qualityOf(int value) {
        return value;
    }

    private static int sellIn(int value) {
        return value;
    }
}