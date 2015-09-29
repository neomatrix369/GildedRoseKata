package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class GildedRoseByImplShould {

    private final String useCaseDescription;
    private final String itemName;
    private final int actualSellIn;
    private final int actualQuality;
    private final int expectedSellIn;
    private final int expectedQuality;

    @Parameterized.Parameters(name = "{0}: Quality of item {1} with a sell in days of {2}, with quality of {3}, changes to quality of {5}, as sell in day changes to {4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {"The quality of Aged Brie increases as Sell In days decreases",
                                "Aged Brie", sellIn(2), qualityOf(1), sellIn(1), qualityOf(2)},
                        {"The quality of Aged Brie increases, if quality is less than 50 as Sell In days decreases",
                                "Aged Brie", sellIn(1), qualityOf(1), sellIn(0), qualityOf(2)},
                        {"The quality of Aged Brie increases by 2, if its past the Sell in date, only if quality is less than 50",
                                "Aged Brie", sellIn(0), qualityOf(47), sellIn(-1), qualityOf(49)},

                        {"The quality of Backstage Passes increases by 1, if quality is less than 50 and Sell In days is 11",
                                "Backstage passes to a TAFKAL80ETC concert", sellIn(11), qualityOf(1), sellIn(10), qualityOf(2)},
                        {"The quality of Backstage Passes increases by 2, if quality is less than 50 and Sell In days is 10",
                                "Backstage passes to a TAFKAL80ETC concert", sellIn(10), qualityOf(1), sellIn(9), qualityOf(3)},
                        {"The quality of Backstage Passes increases by 2, if quality is less than 50 and Sell In days is 10",
                                "Backstage passes to a TAFKAL80ETC concert", sellIn(10), qualityOf(1), sellIn(9), qualityOf(3)},
                        {"The quality of Backstage Passes increases by 3, if quality is less than 50 and Sell In days is 5",
                                "Backstage passes to a TAFKAL80ETC concert", sellIn(5), qualityOf(1), sellIn(4), qualityOf(4)},
                        {"The quality of Backstage Passes is set to 0, if Sell In days is past the date and quality is 1",
                                "Backstage passes to a TAFKAL80ETC concert", sellIn(0), qualityOf(1), sellIn(-1), qualityOf(0)},

                        {"The quality of Any item (other than ...) decreases by 2, if Sell In days is past the date and quality is 2",
                                "Any item", sellIn(0), qualityOf(2), sellIn(-1), qualityOf(0)},
                }
        );
    }

    public GildedRoseByImplShould(
            String useCaseDescription,
            String itemName,
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

        assertThat("Sell in: " + useCaseDescription, app.items[0].sellIn, is(equalTo(expectedSellIn)));
        assertThat("Quality: " + useCaseDescription, app.items[0].quality, is(equalTo(expectedQuality)));
    }

    private GildedRose prepareGildedRose() {
        Item[] items = new Item[]{new Item(itemName, actualSellIn, actualQuality)};
        return new GildedRose(items);
    }

    private static int sellIn(int value) {
        return value;
    }

    private static int qualityOf(int value) {
        return value;
    }
}