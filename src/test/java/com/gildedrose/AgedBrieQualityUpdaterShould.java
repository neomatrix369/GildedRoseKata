package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.gildedrose.Constants.AGED_BRIE;
import static com.gildedrose.TestHelper.qualityOf;
import static com.gildedrose.TestHelper.sellInOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class AgedBrieQualityUpdaterShould {
    private final String useCaseDescription;
    private final String itemName;
    private final int initialSellIn;
    private final int initialQuality;
    private final int expectedQuality;

    @Parameterized.Parameters(name = "{0}: Quality of item {1} with a sell in days of {2}, with quality of {3}, changes to quality of {5}, as sell in day changes to {4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                        {"The quality of Aged Brie increases as Sell In days decreases",
                                AGED_BRIE, sellInOf(2), qualityOf(1), qualityOf(2)},
                        {"The quality of Aged Brie increases, if quality is less than 50 as Sell In days decreases",
                                AGED_BRIE, sellInOf(1), qualityOf(1), qualityOf(2)},
                        {"The quality of Aged Brie increases, but not past 50 as Sell In days decreases",
                                AGED_BRIE, sellInOf(1), qualityOf(50), qualityOf(50)},
                        {"The quality of Aged Brie increases by 1, but not past 50 even when item is expired",
                                AGED_BRIE, sellInOf(-1), qualityOf(49), qualityOf(50)},
                        {"The quality of Aged Brie stays at 50 even when item is expired, and sell in days continue to decrease",
                                AGED_BRIE, sellInOf(-1), qualityOf(50), qualityOf(50)},
                }
        );
    }

    public AgedBrieQualityUpdaterShould(
            String useCaseDescription,
            String itemName,
            int initialSellIn,
            int initialQuality,
            int expectedQuality) {
        this.useCaseDescription = useCaseDescription;
        this.itemName = itemName;
        this.initialSellIn = initialSellIn;
        this.initialQuality = initialQuality;
        this.expectedQuality = expectedQuality;
    }

    @Test
    public void
    change_quality_item_with_respective_sellin_date_and_starting_quality() {
        Item item = new Item(itemName, initialSellIn, initialQuality);

        new AgedBrieQualityUpdater(item).update();

        assertThat(useCaseDescription, item.quality, is(equalTo(expectedQuality)));
    }
}