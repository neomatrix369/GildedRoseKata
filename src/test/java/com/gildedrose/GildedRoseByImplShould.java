package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.gildedrose.ItemByName.AGED_BRIE;
import static com.gildedrose.ItemByName.BACKSTAGE_PASSES;
import static com.gildedrose.ItemByName.ANY_OTHER_ITEM;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class GildedRoseByImplShould {

    private final String useCaseDescription;
    private final ItemByName itemName;
    private final int actualSellIn;
    private final int actualQuality;
    private final int expectedSellIn;
    private final int expectedQuality;

    @Parameterized.Parameters(name = "{0}: Quality of item {1} with a sell in days of {2}, with quality of {3}, changes to quality of {5}, as sell in day changes to {4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {"The quality of Aged Brie increases as Sell In days decreases",
                                AGED_BRIE, sellIn(2), qualityOf(1), sellIn(1), qualityOf(2)},
                        {"The quality of Aged Brie increases, if quality is less than 50 as Sell In days decreases",
                                AGED_BRIE, sellIn(1), qualityOf(1), sellIn(0), qualityOf(2)},
                        {"The quality of Aged Brie increases by 2, if its past the Sell in date, only if quality is less than 50",
                                AGED_BRIE, sellIn(0), qualityOf(47), sellIn(-1), qualityOf(49)},

                        {"The quality of Backstage Passes increases by 1, if quality is less than 50 and Sell In days is 11",
                                BACKSTAGE_PASSES, sellIn(11), qualityOf(1), sellIn(10), qualityOf(2)},
                        {"The quality of Backstage Passes increases by 2, if quality is less than 50 and Sell In days is 10",
                                BACKSTAGE_PASSES, sellIn(10), qualityOf(1), sellIn(9), qualityOf(3)},
                        {"The quality of Backstage Passes increases by 2, if quality is less than 50 and Sell In days is 10",
                                BACKSTAGE_PASSES, sellIn(10), qualityOf(1), sellIn(9), qualityOf(3)},
                        {"The quality of Backstage Passes increases by 3, if quality is less than 50 and Sell In days is 5",
                                BACKSTAGE_PASSES, sellIn(5), qualityOf(1), sellIn(4), qualityOf(4)},
                        {"The quality of Backstage Passes is set to 0, if Sell In days is past the date and quality is 1",
                                BACKSTAGE_PASSES, sellIn(0), qualityOf(1), sellIn(-1), qualityOf(0)},

                        {"The quality of Any item (other than ...) decreases by 2, if Sell In days is past the date and quality is 2",
                                ANY_OTHER_ITEM, sellIn(0), qualityOf(2), sellIn(-1), qualityOf(0)},
                }
        );
    }

    public GildedRoseByImplShould(
            String useCaseDescription,
            ItemByName itemName,
            int actualSellIn,
            int actualQuality,
            int expectedSellIn,
            int expectedQuality) {
        this.useCaseDescription = useCaseDescription;
        this.itemName = itemName;
        this.actualSellIn = actualSellIn;
        this.actualQuality = actualQuality;
        this.expectedSellIn = expectedSellIn;
        this.expectedQuality = expectedQuality;
    }

    @Test
    public void
    change_quality_item_with_respective_sellin_date_and_starting_quality() {
        GildedRose app = prepareGildedRose();

        app.updateQuality();

        Item item = app.firstItem();
        assertThat("Sell in: " + useCaseDescription, item.sellIn, is(equalTo(expectedSellIn)));
        assertThat("Quality: " + useCaseDescription, item.quality, is(equalTo(expectedQuality)));
    }

    private GildedRose prepareGildedRose() {
        ItemList itemList = new ItemList(new Item[] {
                new Item(itemName.toString(), actualSellIn, actualQuality)}
        );
        return new GildedRose(itemList);
    }

    private static int sellIn(int value) {
        return value;
    }

    private static int qualityOf(int value) {
        return value;
    }
}