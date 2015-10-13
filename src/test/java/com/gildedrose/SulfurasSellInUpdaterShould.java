package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SulfurasSellInUpdaterShould {
    @Test public void
    not_change_the_sell_in_of_the_item() {
        int initialQuality = 1;
        int initialSellIn = 10;
        Item item = new Item(Constants.SULFURAS, initialSellIn, initialQuality);

        SulfurasSellInUpdater sulfurasSellInUpdater = new SulfurasSellInUpdater(item);
        sulfurasSellInUpdater.update();

        int expectedSellIn = 10;
        assertThat(item.sellIn, is(equalTo(expectedSellIn)));
    }

}