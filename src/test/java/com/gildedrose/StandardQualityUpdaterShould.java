package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.gildedrose.Constants.STANDARD_ITEM;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class StandardQualityUpdaterShould {
    private final String useCaseDescription;
    private final String itemName;
    private final int initialSellIn;
    private final int initialQuality;
    private final int expectedQuality;

    @Parameterized.Parameters(name = "{0}: Quality of item {1} with a sell in days of {2}, with quality of {3}, changes to quality of {5}, as sell in day changes to {4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {"The quality of Standard item decreases by 1, if Sell In days is not past the date and quality is 2",
                                STANDARD_ITEM, sellIn(1), qualityOf(2), qualityOf(1)},
                        {"The quality Standard item stays the same, if quality is 0 to start with",
                                STANDARD_ITEM, sellIn(1), qualityOf(0), qualityOf(0)},
                        {"The quality of Standard item decreases by 1, if Sell In days is near expiry and quality is 2",
                                STANDARD_ITEM, sellIn(0), qualityOf(2), qualityOf(1)},
                        {"The quality of Standard item decreases by 2 (twice as fast as normal), if Sell In days is past the date and quality is 2",
                                STANDARD_ITEM, sellIn(-1), qualityOf(2), qualityOf(0)},
                        {"The quality of Standard item decreases by 2 (twice as fast as normal), if Sell In days is past the date and quality is 4",
                                STANDARD_ITEM, sellIn(-1), qualityOf(4), qualityOf(2)},
                }
        );
    }

    public StandardQualityUpdaterShould(
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

        StandardQualityUpdater standardQualityUpdater = new StandardQualityUpdater(item);
        standardQualityUpdater.update();

        assertThat(useCaseDescription, item.quality, is(equalTo(expectedQuality)));
    }

    private static int sellIn(int value) {
        return value;
    }

    private static int qualityOf(int value) {
        return value;
    }
}