package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.Constants.SULFURAS;
import static com.gildedrose.TestHelper.createItemFrom;
import static com.gildedrose.TestHelper.qualityOf;
import static com.gildedrose.TestHelper.sellInOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SulfurasQualityUpdaterShould {

    @Test public void
    not_change_quality_of_the_item() {
        Item item = createItemFrom(SULFURAS, sellInOf(0), qualityOf(80));

        new SulfurasQualityUpdater(item).update();

        assertThat(item.quality, is(equalTo(qualityOf(80))));
    }

}