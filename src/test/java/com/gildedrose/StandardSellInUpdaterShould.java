package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.Constants.STANDARD_ITEM;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StandardSellInUpdaterShould {
    @Test public void
    decrease_the_sell_in_of_an_item() {
        int initialQuality = 10;
        int initialSellIn = 6;
        Item item = new Item(STANDARD_ITEM, initialSellIn, initialQuality);

        StandardSellInUpdater standardSellInUpdater = new StandardSellInUpdater(item);
        standardSellInUpdater.update();

        int expectedSellIn = 5;
        assertThat(item.sellIn, is(equalTo(expectedSellIn)));
    }

}