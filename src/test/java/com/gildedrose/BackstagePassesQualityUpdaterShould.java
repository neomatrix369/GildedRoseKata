package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.gildedrose.Constants.BACKSTAGE_PASSES;
import static com.gildedrose.TestHelper.qualityOf;
import static com.gildedrose.TestHelper.sellInOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BackstagePassesQualityUpdaterShould {
    private final String useCaseDescription;
    private final String itemName;
    private final int initialSellIn;
    private final int initialQuality;
    private final int expectedQuality;

    @Parameterized.Parameters(name = "{0}: Quality of item {1} with a sell in days of {2}, with quality of {3}, changes to quality of {5}, as sell in day changes to {4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {"The quality of Backstage Passes increases by 1, if quality is less than 50 and Sell In days is 11",
                                BACKSTAGE_PASSES, sellInOf(11), qualityOf(1), qualityOf(2)},
                        {"The quality of Backstage Passes increases by 2, if quality is less than 50 and Sell In days is 10",
                                BACKSTAGE_PASSES, sellInOf(10), qualityOf(1), qualityOf(3)},
                        {"The quality of Backstage Passes increases by 3, if quality is less than 50 and Sell In days is 5",
                                BACKSTAGE_PASSES, sellInOf(5), qualityOf(1), qualityOf(4)},
                        {"The quality of Backstage Passes is set to 4, if Sell In days is near the expiry date and quality is 1",
                                BACKSTAGE_PASSES, sellInOf(0), qualityOf(1), qualityOf(4)},
                        {"The quality of Backstage Passes is set to 0, if item is past sell in date (expired) and quality is 1",
                                BACKSTAGE_PASSES, sellInOf(-1), qualityOf(1), qualityOf(0)},
                }
        );
    }

    public BackstagePassesQualityUpdaterShould(
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

        new BackstagePassesQualityUpdater(item).update();

        assertThat(useCaseDescription, item.quality, is(equalTo(expectedQuality)));
    }
}