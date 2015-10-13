package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.Constants.SULFURAS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SulfurasQualityUpdaterShould {

    @Test public void
    not_change_quality_of_the_item() {
        int initialSellIn = 0;
        int initialQuality = 80;
        Item item = new Item(SULFURAS, initialSellIn, initialQuality);

        SulfurasQualityUpdater sulfurasQualityUpdater = new SulfurasQualityUpdater(item);
        sulfurasQualityUpdater.update();

        int expectedQuality = 80;
        assertThat(item.quality, is(equalTo(expectedQuality)));
    }

}