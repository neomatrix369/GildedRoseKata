package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.gildedrose.Constants.CONJURED;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ConjuredQualityUpdaterShould {
    private final String useCaseDescription;
    private final String itemName;
    private final int initialSellIn;
    private final int initialQuality;
    private final int expectedQuality;

    @Parameterized.Parameters(name = "{0}: Quality of item {1} with a sell in days of {2}, with quality of {3}, changes to quality of {5}, as sell in day changes to {4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                        {"The quality of Conjured item decreases to 0, when Sell In is 1 and Quality is 1",
                                CONJURED, sellIn(1), qualityOf(1), qualityOf(0)},
                        {"The quality of Conjured item decreases to 0, when Sell In is near expiry and Quality is 2",
                                CONJURED, sellIn(0), qualityOf(2), qualityOf(0)},
                        {"The quality of Conjured item stays at 0, when Sell In is 1 and Quality is 0",
                                CONJURED, sellIn(1), qualityOf(0), qualityOf(0)},
                        {"The quality of Conjured item decreases by 4 (twice as fast as normal), when Sell In is -1 and Quality is 6",
                                CONJURED, sellIn(-1), qualityOf(6), qualityOf(2)},
                }
        );
    }

    public ConjuredQualityUpdaterShould(
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

        ConjuredQualityUpdater conjuredQualityUpdater = new ConjuredQualityUpdater(item);
        conjuredQualityUpdater.update();

        assertThat(useCaseDescription, item.quality, is(equalTo(expectedQuality)));
    }

    private static int sellIn(int value) {
        return value;
    }

    private static int qualityOf(int value) {
        return value;
    }
}