package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.Constants.SULFURAS;
import static com.gildedrose.TestHelper.qualityOf;
import static com.gildedrose.TestHelper.sellInOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SulfurasSellInUpdaterShould {
    @Test public void
    not_change_the_sell_in_of_the_item() {
        Item item = new Item(SULFURAS, sellInOf(10), qualityOf(1));

        new SulfurasSellInUpdater(item).update();

        assertThat(item.sellIn, is(equalTo(sellInOf(10))));
    }

}