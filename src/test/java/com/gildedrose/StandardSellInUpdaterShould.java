package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.Constants.STANDARD_ITEM;
import static com.gildedrose.TestHelper.qualityOf;
import static com.gildedrose.TestHelper.sellInOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StandardSellInUpdaterShould {
    @Test public void
    decrease_the_sell_in_of_an_item() {
        Item item = TestHelper.createItemFrom(STANDARD_ITEM, sellInOf(6), qualityOf(10));

        new StandardSellInUpdater(item).update();

        assertThat(item.sellIn, is(equalTo(sellInOf(5))));
    }

}